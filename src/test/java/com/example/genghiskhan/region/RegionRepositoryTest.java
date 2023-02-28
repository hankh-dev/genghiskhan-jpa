package com.example.genghiskhan.region;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED) // 이코드를 지우면 실DB에 입력되지 않는다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 이코드는 embeded db가 아닌 실DB(예: mysql)로 연결해준다.
class RegionRepositoryTest {

    @Autowired
    private RegionRepository regionRepository;

    @Test
    void test() {

        Optional<Region> optionalRegion = regionRepository.findById(10);
        if(optionalRegion.isPresent()) {
            Region region = optionalRegion.get();
//            System.out.println(region);
//            System.out.println(region.getRegion2());
//            region.getRegion2().forEach(r-> System.out.println(r.getName()));

            // jackson 사용시 stack overflow error 방지
            // ref : https://stackoverflow.com/a/10209979
            for (Region region2 : region.getRegion2()) {
                region2.setRegion2(null);
            }

            ObjectMapper mapper = new ObjectMapper();
            try {
                // 객체를 JSON 타입의 파일로 변환
//                mapper.writeValue(new File("c:\\user.json"), user);
                // 객체를 JSON 타입의 String으로 변환
//                String jsonInString01 = mapper.writeValueAsString(region);
//                System.out.println(jsonInString01);

                // 객체를 JSON 타입의 String으로 변환 및 정렬
                String jsonInString02 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(region);
                System.out.println(jsonInString02);

            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        Region region = regionRepository.findById(44).orElse(null);
//        System.out.println(region.getName());


//        Region region2 = regionRepository.findById((byte)2).get();
//        Region region3 = regionRepository.findById((byte)3).get();

//        System.out.println(region1);
//        System.out.println(region2);
//        System.out.println(region3);
//
//        region1.setName("Region 1");
//        region2.setName("Region 2");
//        region3.setName("Region 3");
//
//        List<Region> connectedRegions1 = new ArrayList<>();
//        connectedRegions1.add(region2);
//        connectedRegions1.add(region3);
//        region1.setConnectedRegions(connectedRegions1);
//
//        List<Region> connectedRegions2 = new ArrayList<>();
//        connectedRegions2.add(region1);
//        region2.setConnectedRegions(connectedRegions2);
//
//        List<Region> connectedRegions3 = new ArrayList<>();
//        connectedRegions3.add(region1);
//        region3.setConnectedRegions(connectedRegions3);

        // given
//        Region region = new Region();
//        region.setId((byte) 1);
//        region.setName("몽골고원");
//
//        regionRepository.save(region);



//        regionRepository.flush();
//
//        Region region1 = regionRepository.findById((byte)1).get();
//
//        System.out.println(region1.toString());


        // when
//        final Role savedRole = roleRepository.save(role);

        // then
//        assertEquals(roleName, savedRole.getRoleName());
    }
}