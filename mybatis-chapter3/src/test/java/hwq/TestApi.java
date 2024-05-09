package hwq;

import com.hwq.binding.MapperRegister;
import com.hwq.mapper.UserMapper;
import com.hwq.session.SqlSession;
import com.hwq.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

/**
 * @author HWQ
 * @date 2024/5/9 19:37
 * @description
 */
public class TestApi {
    @Test
    public void test_MapperProxyFactory() {
        MapperRegister mapperRegister = new MapperRegister();
        // 自定包路径自动添加mapper代理类
        mapperRegister.addMappers("com.hwq.mapper");
        SqlSession sqlSession = new DefaultSqlSessionFactory(mapperRegister).openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String hwq = mapper.queryUserByName("hwq");
        System.out.println(hwq);
    }
}
