package com.example.Basketballtelegrambot.command;

import com.example.Basketballtelegrambot.parser.Event;
import com.example.Basketballtelegrambot.service.SendBotMessageService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Past Events {@link Command}.
 */
public class PastCommand implements  Command{

    private final SendBotMessageService sendBotMessageService;

    public final static String  PAST_EVENT_MESSAGE = "Here is results of matches ";

    List<Event> eventList = new ArrayList<>();


    public PastCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        {
            try {
                Document doc = Jsoup.connect("https://www.oddsportal.com/matches/basketball/20220814/").get();
                Elements information = doc.getElementsByAttribute("class.table-main tbody");
                for (Element info : information) {
                    Event events = new Event();
                    try {

                        if(eventList.size() > 0) {
                            eventList.clear();
                        }

                        Elements tournament = info.getElementsByClass("first2 tl");
                        Elements team1 = info.getElementsByClass("name table-participant");
                        Elements result = info.getElementsByClass("center bold table-odds table-score");
                        Element odd1 = info.getElementsByClass("odds-nowrp").first().child(0);
                        Element odd2 = info.getElementsByClass("odds-nowrp").first().child(1);

                        events.setTournaent(tournament.text());
                        events.setResult(result.text());
                        events.setTeam1(team1.text());
                        events.setOdd1(odd1.text());
                        events.setOdd2(odd2.text());
                        eventList.add(events);
                        eventList.forEach(event -> sendBotMessageService.sendMessage(update.getMessage().getChatId().toString() , event.toStringForPastEvents()));


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
