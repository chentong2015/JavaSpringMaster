package demo.repositories;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class SpringMockitoDemoTest {

    @Test
    public void testMockitoBasic() {
        SessionRepository sessionRepository = Mockito.mock(SessionRepository.class);
        Mockito.when(sessionRepository.count()).thenReturn(10L);
        long count = sessionRepository.count();
        
        Assertions.assertEquals(111L, count);
        Mockito.verify(sessionRepository).count();
    }
}
