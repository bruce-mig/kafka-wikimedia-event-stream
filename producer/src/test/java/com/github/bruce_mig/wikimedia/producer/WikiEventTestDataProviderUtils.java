package com.github.bruce_mig.wikimedia.producer;

import lombok.experimental.UtilityClass;

@UtilityClass
public class WikiEventTestDataProviderUtils {

    public static String supplyWikiEvent() {
        return """
                event: message
                id: [{"topic":"eqiad.mediawiki.recentchange","partition":0,"timestamp":1744183398001},{"topic":"codfw.mediawiki.recentchange","partition":0,"offset":-1}]
                data: {"$schema":"/mediawiki/recentchange/1.0.0","meta":{"uri":"https://en.wikipedia.org/wiki/Monica_Rizzio","request_id":"ab11025f-32c6-4eea-8833-16ec7b8c9412","id":"be377c94-ae8a-42f6-bbeb-99b7ad4b3ad8","dt":"2025-04-09T07:23:18Z","domain":"en.wikipedia.org","stream":"mediawiki.recentchange","topic":"eqiad.mediawiki.recentchange","partition":0,"offset":5498062608},"id":1893332824,"type":"edit","namespace":0,"title":"Monica Rizzio","title_url":"https://en.wikipedia.org/wiki/Monica_Rizzio","comment":"fix","timestamp":1744183398,"user":"Natg 19","bot":false,"notify_url":"https://en.wikipedia.org/w/index.php?diff=1284712010&oldid=1284711971","minor":false,"length":{"old":14194,"new":14182},"revision":{"old":1284711971,"new":1284712010},"server_url":"https://en.wikipedia.org","server_name":"en.wikipedia.org","server_script_path":"/w","wiki":"enwiki","parsedcomment":"fix"}
                """;
    }
}
