package community.community.controller;
import community.community.mapper.UserMapper;
import community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    private String token;
    @GetMapping("/index")
    public String  indexTest(HttpServletRequest request)
    {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies)
        {
            if(cookie.getName().equals("token"))
            {
                 token= cookie.getValue();
                User  user = userMapper.findByCookie(token);
                request.getSession().setAttribute("user", user);
                 break;
            }
        }
        return "index";
    }

}
