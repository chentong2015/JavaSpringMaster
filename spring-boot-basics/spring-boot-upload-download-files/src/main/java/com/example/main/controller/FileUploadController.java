package com.example.main.controller;

import com.example.main.exception.StorageFileNotFoundException;
import com.example.main.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    // 列举出所有上传到server的文件，通过model显示在前端界面上
    // build().toUri() 提供的文件路径是可以下载的
    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        model.addAttribute("message", "My upload download Application");
        model.addAttribute("files", storageService
                .loadAll()
                .map(path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class, "serveFile",
                        path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));
        // 通过名称找到resources/templates路径下的指定web文件
        return "uploadForm";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        storageService.store(file);
        // 重动向到指定index页面，显示上传成功的信息
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        // redirect:/重定向将调用对应的GetMapping()方法
        return "redirect:/";
    }

    // 在"redirect:/"重定向的时候，会在页面抛出Not Found 404的异常
    // 通过自定义实现/error/错误处理页面来优化错误信息的显示 !!
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<StorageFileNotFoundException> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

    // TODO. 直接在流量器输入指定的路径进行下载
    // http://localhost:8080/files/DataLayer%20Config.txt
    // 根据名称在server端找到指定的resource资源，作为请求的附件进行下载 !!
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
