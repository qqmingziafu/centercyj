package center.health;

import center.authority.Authority;
import center.authority.AuthorityEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*将这个Controller下面的所有接口设置返回格式json  就不用requestBody了*/
@RestController
public class Health {

    @RequestMapping("/health")
    @Authority(action = AuthorityEnum.SELECT)
    public String getHealth(){
        return null;
    }

}
