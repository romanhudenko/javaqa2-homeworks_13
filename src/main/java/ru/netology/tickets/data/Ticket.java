package ru.netology.tickets.data;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private double price;
    private String from;
    private String to;
    private double timeInFlightMinutes;

    public Ticket(int id, double price, String from, String to, double timeInFlightMinutes) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.timeInFlightMinutes = timeInFlightMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getTimeInFlightMinutes() {
        return timeInFlightMinutes;
    }

    public void setTimeInFlightMinutes(double timeInFlightMinutes) {
        this.timeInFlightMinutes = timeInFlightMinutes;
    }

    @Override
    public int compareTo(Ticket ticket) {
        if (price > ticket.getPrice()) {
            return 1;
        }
        if (price < ticket.getPrice()) {
            return -1;
        }
        return 0;
    }
}