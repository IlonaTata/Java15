public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];
    public void add(Ticket type) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = type;
        tickets = tmp;
    }
    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket type : tickets) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }
    public void remove(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket type : tickets) {
            if (type.getId() != id) {
                tmp[copyToIndex] = type;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }


    }




