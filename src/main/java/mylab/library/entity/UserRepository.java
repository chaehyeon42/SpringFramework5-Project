package mylab.library.entity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public String getDbType() { return "MySQL"; }
    public void save() { System.out.println("사용자 정보가 DB에 저장되었습니다."); }
}