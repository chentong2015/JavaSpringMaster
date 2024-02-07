package demo.controller;

import demo.services.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageableController {

    private final UserCrudService userCrudService;

    @Autowired
    public UserPageableController(UserCrudService userCrudService) {
        this.userCrudService = userCrudService;
    }

    // TODO. 执行一个分页查询, 将数据分页返回
    // PageableDefault默认一页返回10个User对象
    @GetMapping("/list/users")
    public String findAllByNameAndEmail(
            @PageableDefault(size = 8, sort = {"updateTime"})
            Pageable pageable, Model model) {
        model.addAttribute("page", userCrudService.findAllByNameAndEmail(pageable));
        return "success";
    }
}
