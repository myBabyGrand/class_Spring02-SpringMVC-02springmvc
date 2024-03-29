package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView modelAndView = new ModelAndView("response/hello").addObject("data", "hello1");
        return modelAndView;
    }

    /**
     * @ResponseBody 가 없으면 response/hello 로 뷰 리졸버가 실행되어서 뷰를 찾고, 렌더링 한다.
     * @ResponseBody 가 있으면 뷰 리졸버를 실행하지 않고, HTTP 메시지 바디에 직접 response/hello 라는 문자가 입력된다
     * */
    @RequestMapping("/response-view-v2")
    public String responseViewV1(Model model){
        model.addAttribute("data", "hello2");
        return "response/hello";
    }

    /**
     * 명시성이 너무 떨어지고 이렇게 딱 맞는 경우도 많이 없어서, 권장하지 않음.
     * controller를 사용하고 URL경로 = view의 경로
     * */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello3");
    }
}
