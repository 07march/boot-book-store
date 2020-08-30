package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.User;
import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.repository.KeyRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Transactional
@Service
@Data
public class KeyServiceImpl implements KeyService {

    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyServiceImpl that = (KeyServiceImpl) o;
        return age == that.age &&
                Objects.equals(keyRepository, that.keyRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, keyRepository);
    }

    public  void main(String[] args, int a) {
//        User user = new User(22, "Test");
//        user.clone()

//        Class<KeyServiceImpl> keyServiceClass = KeyServiceImpl.class;
//        Class<? extends Number> aClass = new Integer().getClass();


//        a = 22;
//        int count = 9;
        List<Integer> ab = new ArrayList<Integer>(){

            int count = 0;

            {
//                System.out.println(a);
                add(22);
                add(33);
            }

            @Override
            public boolean add(Integer integer) {
                count++;
                System.out.println("Total " + count);;
                return super.add(integer);
            }
        };

        ab.add(22);
        ab.add(33);
        ab.add(44);
    }

    private final KeyRepository keyRepository;

//    public static class Abc{
//
//    }
//
//    public class Inner{
//
//    }
//
//    public interface Nn{
//        class Mn{
//
//        }
//    }

    @Override
    public Key findKeyByUuid(UUID uuid) {
        return keyRepository.findKeyByUuid(uuid);
    }

    @Override
    public Key findKeyByRole(Role role) {
        return keyRepository.findKeyByRole(role);
    }

    @Override
    public Key save(Key key) {
        return keyRepository.save(key);
    }
}
