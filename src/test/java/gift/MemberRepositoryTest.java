package gift;

import gift.entity.Member;
import gift.repository.MemberRepository;
import gift.dto.Role;  // Role enum을 import 합니다.
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testFindByEmail() {
        // Given
        String uniqueEmail = "test-" + System.currentTimeMillis() + "@example.com";
        Member member = new Member(uniqueEmail, "password123");
        memberRepository.save(member);

        // When
        Member foundMember = memberRepository.findByEmail(uniqueEmail);

        // Then
        assertThat(foundMember).isNotNull();
        assertThat(foundMember.getEmail()).isEqualTo(uniqueEmail);
        assertThat(foundMember.getPassword()).isEqualTo("password123");
        assertThat(foundMember.getRole()).isEqualTo(Role.USER);
    }

}
