package org.jvrb.roadmap.exercise50;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class App50 {

    private static final String USR_KEY = "Users ...: ";
    private static final String TAG_KEY = "Hashtags : ";
    private static final String WEB_KEY = "Webs ....: ";

    private static final String HEADER = """
            
            DETECTOR DE HANDLES
            ===================""";

    public static void main(String[] args) {
        System.out.println(HEADER);
        String text = "En esta actividad de @mouredev, resolvemos #retos de #programacion desde https://retosdeprogramacion.com/semanales2022, que @braismoure aloja en www.github.com";
        Map<String, List<String>> handlesMap = getHandles(text);
        showHandles(handlesMap);
    }

    private static Map<String, List<String>> getHandles(String text) {
        Map<String, List<String>> handlesMap = Map.of(
                USR_KEY, new ArrayList<>(),
                TAG_KEY, new ArrayList<>(),
                WEB_KEY, new ArrayList<>()
        ); // Estructura inmutable

        Matcher userMatcher = Pattern.compile("@[\\wÑñ]+").matcher(text);
        Matcher hastagMatcher = Pattern.compile("#[\\wÑñ]+").matcher(text);
        Matcher webMatcher = Pattern.compile("(www.|https?://)[\\w/]+(\\.com|\\.es)[\\w/]*").matcher(text);

        while (userMatcher.find()) handlesMap.get(USR_KEY).add(userMatcher.group());
        while (hastagMatcher.find()) handlesMap.get(TAG_KEY).add(hastagMatcher.group());
        while (webMatcher.find()) handlesMap.get(WEB_KEY).add(webMatcher.group());

        return handlesMap;
    }

    private static void showHandles(Map<String, List<String>> handlesMap) {
        handlesMap.forEach((key, value) -> System.out.println(key + value));
    }
}
