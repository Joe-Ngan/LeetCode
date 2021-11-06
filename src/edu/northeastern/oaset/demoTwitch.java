package edu.northeastern.oaset;

import java.util.*;

public class demoTwitch {
    public static Map<String, Streaming> streamingMap;
    public static String[] streaming;
    public static String[] input;
    public static void main(String[] streaming, String[] comm) {
        streaming = new String[]{"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"};
//        input = new String[]{"StreamerOnline", "Bugha", "75000", "Fortnite", "StreamerOnline","Tenzo", "30000", "Volorant", "ViewsInCategory", "Fortnite","TopStreamerInCategory", "Valorant"};
        input = new String[]{"StreamerOnline","Tenzo", "30000", "Volorant","StreamerOffline", "Pokimane", "Valorant", "ViewsInCategory", "Fortnite", "TopStreamer"};
        streamingMap = new HashMap<>();
        //1.put streaming data in map
        for(int i = 0; i<streaming.length; i+=3){
            String name = streaming[i];
            Streaming s = new Streaming(streaming[i], Integer.parseInt(streaming[i+1]), streaming[i+2], true);
            streamingMap.put(name, s);
        }
        //2. analyse the input
        int i = 0;
        while(i<input.length){
            String s = input[i];
            switch (s) {
                case "StreamerOnline":
                    String[] streamerOnline = new String[4];
                    System.arraycopy(input, i, streamerOnline, 0, 4);
                    streaming = StreamerOnline(streamerOnline, streaming);
                    i+=4;
                    System.out.println(Arrays.toString(streaming));
                    break;
                case "UpdateViews":
                    String[] updateViews = new String[4];
                    System.arraycopy(input, i, updateViews, 0, 4);
                    UpdateViews(updateViews);
                    System.out.println(Arrays.toString(streaming));
                    i+=4;
                    break;
                case "UpdateCategory":
                    String[] updateCategory = new String[4];
                    System.arraycopy(input, i, updateCategory, 0, 4);
                    UpdateCategory(updateCategory);
                    System.out.println(Arrays.toString(streaming));
                    i+=4;
                    break;
                case "StreamerOffline":
                    String[] streamerOffline = new String[3];
                    System.arraycopy(input, i, streamerOffline, 0, 3);
                    streaming = StreamerOffline(streamerOffline);
                    System.out.println(Arrays.toString(streaming));
                    i+=3;
                    break;
                case "ViewsInCategory":
                    String[] viewsInCategory = new String[2];
                    System.arraycopy(input, i, viewsInCategory, 0, 2);
                    int view = ViewsInCategory(viewsInCategory);
                    System.out.println(view);
                    i+=2;
                    break;
                case "TopStreamerInCategory":
                    String[] topStreamerInCategory = new String[2];
                    System.arraycopy(input, i, topStreamerInCategory, 0, 2);
                    String name = TopStreamerInCategory(topStreamerInCategory);
                    System.out.println(name);
                    i+=2;
                    break;
                case "TopStreamer":
                    String toppestName = TopStreamer();
                    System.out.println(toppestName);
                    i++;
                    break;
                default:
                    i++;
                    break;
            }
        }
    }

    //new class: Streaming as the map value
    public static class Streaming{
        private String streamerName;
        private int views;
        private String category;
        private boolean online;

        public Streaming(String streamerName, int views, String category, boolean online){
            this.streamerName = streamerName;
            this.views = views;
            this.category = category;
            this.online = true;
        }
    }

    public static String[] StreamerOnline(String[] input, String[] streaming){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input: StreamerOnline, AOC, 75000, Just Chatting
        //output: [Ninja, 1000000, Fortnite, Pokimane, 40000, Valorant,AOC, 75000, Just Chatting]

        //1.map change
        Streaming newS = new Streaming(input[1], Integer.parseInt(input[2]), input[3], true);
        if(!streamingMap.containsKey(input[1])){
            streamingMap.put(input[1], newS);
        }else{
            Streaming s = streamingMap.get(input[1]);
            s.online = true;
            streamingMap.put(input[1], s);
        }

        //2. streaming change: merge two arrays
        String[] newOnline = {input[1], input[2], input[3]};
        List<String> list = new ArrayList(Arrays.asList(streaming));
        list.addAll(Arrays.asList(newOnline));
        return list.toArray(new String[list.size()]);
    }

    public static void UpdateViews(String[] input){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input:UpdateViews, Ninja, 120000, Fortnite
        //output: Update Ninja's view count to 120000.
        // If the streamer is not streaming within that category, this command can be ignored.

        //1.map change
        Streaming s = streamingMap.get(input[1]);
        if(s.category == input[3]){
            s.views = Integer.parseInt(input[2]);
        }
        streamingMap.put(input[1], s);
        //2. streaming change: change view int
        for(int i = 0; i<streaming.length; i++){
            if(i+1<streaming.length && streaming[i].equals(input[1])){
                streaming[i+1] = input[2];
            }
        }
    }

    public static void UpdateCategory(String[] input){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input: UpdateCategory, Ninja, Fortnite, Warzone
        //output: Update Ninja category to Warzone.
        // If the streamer is not streaming within that category, this command can be ignored.
        //1.map change
        Streaming s = streamingMap.get(input[1]);
        if(s.category == input[2]){
            s.category = input[3];
        }
        streamingMap.put(input[1], s);
        //2. streaming change: change category string
        for(int i = 0; i<streaming.length; i++){
            if(i+1<streaming.length && streaming[i].equals(input[1]) && streaming[i+1].equals(input[2])){
                streaming[i+1] = input[3];
            }
        }
    }

    public static String[] StreamerOffline(String[] input){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input: StreamerOffline, Ninja, Fortnite
        //output: [Pokimane, 40000, Valorant] (Ninja data is deleted)
        //1.map change
        Streaming s = streamingMap.get(input[1]);
        s.online = false;
        streamingMap.put(input[1], s);
        //2. streaming change: delete streaming
        int len = streaming.length;
        List<String> result = new LinkedList<>();
        for(int i = 0; i<streaming.length; i++){
            result.add(streaming[i]);
        }
        result.remove(streamingMap.get(input[1]).streamerName);
        result.remove(String.valueOf(streamingMap.get(input[1]).views));
        result.remove(streamingMap.get(input[1]).category);

        String[] newStreaming = new String[result.size()];
        for(int j = 0; j<result.size(); j++){
            newStreaming[j]=result.get(j);
        }
        return newStreaming;
    }

    public static int ViewsInCategory(String[] input){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input: ViewsInCategory, Fortnite
        //output: 100000
        int ans = 0;
        for(Streaming s : streamingMap.values()){
            if(s.category == input[1]){
                ans += s.views;
            }
        }
        return ans;
    }

    public static String TopStreamerInCategory(String[] input){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input: TopStreamerInCategory, Valorant
        //output: Pokimane
        String topStreamer = "?";
        int top = Integer.MIN_VALUE;
        for(Streaming s : streamingMap.values()){
            if(s.category == input[1]){
                if(s.views>top){
                    top = s.views;
                    topStreamer = s.streamerName;
                }
            }
        }
        return topStreamer=="?" ? null : topStreamer;
    }

    public static String TopStreamer(){
        //streaming:"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"
        //input: TopStreamer
        //output: Ninja
        String toppestStreamer = "?";
        int top = Integer.MIN_VALUE;
        for(Streaming s : streamingMap.values()){
            if(s.views>top){
                top = s.views;
                toppestStreamer = s.streamerName;
            }
        }
        return toppestStreamer=="?" ? null: toppestStreamer;
    }
}
