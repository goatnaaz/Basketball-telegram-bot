package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.parser.Event;

import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.*;



/**
 * Future Events {@link Command}.
 */
public class FutureCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String FUTURE_EVENT_MESSAGE =  "Here is future events";

    List<Event> eventList = new ArrayList<>();




    public FutureCommand(SendBotMessageService sendBotMessageService)  {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        {
            try {
                Document doc = Jsoup.connect("https://www.betmonitor.com/odds-comparison/basketball/european-universities-championship-men/10006327").get();
                Elements information = doc.getElementsByAttributeValue("class", "league-event-new");
                for (Element info : information) {
                    Event events = new Event();
                    try {

                        if(eventList.size() > 0) {
                            eventList.clear();
                        }

                        Elements tournament = info.getElementsByClass("league");
                        Elements date = info.getElementsByClass("evtime");
                        Elements team1 = info.getElementsByClass("teams");
                        Element odd1 = info.getElementsByClass("odds").first().child(0);
                        Element odd2 = info.getElementsByClass("odds").first().child(1);

                        events.setTournaent(tournament.text());
                        events.setDate(date.text());
                        events.setTeam1(team1.text());
                        events.setOdd1(odd1.text());
                        events.setOdd2(odd2.text());
                        eventList.add(events);
                        eventList.forEach(event -> sendBotMessageService.sendMessage(update.getMessage().getChatId().toString() , event.toString()));


                    }catch (NullPointerException e){
                        System.out.println("exeption NULL");
                        events.setTournament("no tournament");
                        events.setDate("no date");
                        events.setTeam1("no team");
                        events.setTeam2("no team");
                        events.setOdd1("no odd");
                        events.setOdd2("no odd");
                    }


                }

            } catch (IOException e) {
                System.out.println("exeption IO");

            }
        }


    }
}
