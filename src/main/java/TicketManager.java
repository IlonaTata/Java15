import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket type : repo.findAll()) {
            if (type.getArrivalAirport().contains(arrivalAirport) && type.getDepartureAirport().contains(departureAirport)) {

                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = type;

                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}



