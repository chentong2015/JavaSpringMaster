package demo.controller;

import demo.model.Session;
import demo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller 默认回复的响应 200 as response status for all calls
//  1. 包含常用的请求操作，提供完整的API
// Spring只提供@GetMapping和@PostMapping
//  1. 可以指明请求的类型
//  2. 使用特定的URL路径来处理
@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository repository;

    // TODO: JPA Repository查询数据，返回List<Session>
    //  Spring MVC 将数据传递给Jackson(序列号类库)，将数据转换成JSON返回
    @GetMapping
    public List<Session> list() {
        return repository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Session get(@PathVariable Long id) {
        return repository.getById(id);
    }

    // TODO: Spring MVC 将Body中的Json数据中的attributes自动生成指定类型的对象
    //   提供的是JSON的数据格式，传入并发送请求到指定的URL
    @PostMapping
    // @ResponseStatus(HttpStatus.CREATED) // 自定义要返回的HTTP状态
    public Session create(@RequestBody final Session session) {
        return repository.saveAndFlush(session);
    }

    // 这里需要注明请求的方法RequestMethod
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // 删除之前，需要考虑关联的数据表，执行Transaction事务操作
        repository.deleteById(id);
    }

    // PUT   覆盖数据库中原始的数据
    // PATCH 更新数据库中原始数据的一部分
    // NOTE: 需要验证参数的有效性，再执行数据查询操作
    //
    // http://localhost:8080/api/v1/sessions/2
    // Row body, Type: JSON
    // {
    //    "session_name": "update seesion name",
    //    "session_description": "My new description",
    //    "session_length": 67
    // }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session existingSession = repository.getById(id);
        // 忽略不需要更新的属性
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return repository.saveAndFlush(existingSession);
    }
}
