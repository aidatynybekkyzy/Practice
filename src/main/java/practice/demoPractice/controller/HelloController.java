package practice.demoPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.demoPractice.model.HelloModel;
import practice.demoPractice.repository.HelloRepository;

import javax.websocket.server.PathParam;
import javax.xml.soap.SAAJResult;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private HelloRepository helloRepository;

    @GetMapping("/hello")
    public String myHello( @RequestParam String name){
    return "Hello "+name;
}
@GetMapping("/hello/{name}")
    public String hello( @PathVariable("name")String name){
       return "Hello "+ name;
    }
    @GetMapping("/hello/fio")
    public String helloFio(@RequestParam String  fio, @RequestParam String name){
        return "Hello "+fio+" "+name;
    }
    @GetMapping ("/password")
    public String password(@RequestHeader("pwd") String password){
        if(password == null||password.equals("123")){
            return "success";
        }

        return "failed";
    }
    @GetMapping("/pwd")
    public HelloModel getPwd(@RequestHeader("pwd") String  password){
        return new HelloModel("Great","Ok");
    }
    @PostMapping("/hello")
    public HelloModel postModel(@RequestBody HelloModel helloModel){
        //HelloModel helloModel1 = new HelloModel("aaa","Ok");
         helloRepository.save(helloModel);
        return helloModel;
    }
   // @GetMapping("")
    @GetMapping("/get")
    public List< HelloModel> getGreater(Integer id){
       return helloRepository.getAllGreater(2);
    }
    @GetMapping("/getAll")
    public List< HelloModel> getAll(Integer id){
        return helloRepository.findAll();
    }
}
