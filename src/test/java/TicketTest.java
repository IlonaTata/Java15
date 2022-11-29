import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketTest {
    Ticket type1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket type2 = new Ticket(2, 1299, "VKO", "KZN", 95);
    Ticket type3 = new Ticket(3, 1199, "VKO", "KZN", 95);
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    @Test
    public void shouldAddTicket() {
        repo.add(type1);
        repo.add(type2);
        repo.findAll();
        Ticket[] expected = {type1, type2};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTicketLessExist() {
        repo.add(type1);
        repo.findAll();
        Ticket[] expected = {type1};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTicket() {
        repo.add(type1);
        repo.add(type2);
        repo.findAll();
        repo.remove(1);
        repo.findAll();
        Ticket[] expected = {type2};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveTicketByNotExistId() {
        repo.add(type1);
        repo.add(type2);
        repo.findAll();
        Ticket[] expected = {type1, type2};
        Ticket[] actual = repo.findAll();
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(3);
        });
    }

    @Test
    public void shouldAddTicketByAirport() {
        repo.add(type1);
        repo.add(type2);
        repo.add(type3);
        repo.findAll();
        manager.findAll("VKO", "KZN");
        Ticket[] expected = {type3, type2};
        Ticket[] actual = manager.findAll("VKO", "KZN");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTicketByNotExistAirport() {
        repo.add(type1);
        repo.add(type2);
        repo.findAll();
        manager.findAll("LED", "KZN");
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "KZN");
        Assertions.assertArrayEquals(expected, actual);
    }


}
