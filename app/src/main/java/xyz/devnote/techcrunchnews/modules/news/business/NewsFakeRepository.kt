package xyz.devnote.techcrunchnews.modules.news.business

import com.google.gson.Gson
import kotlinx.coroutines.delay
import xyz.devnote.techcrunchnews.common.Data
import xyz.devnote.techcrunchnews.modules.news.model.NewsRequest
import xyz.devnote.techcrunchnews.modules.news.model.NewsResponse
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class NewsFakeRepository : NewsRepository {
    override suspend fun getNews(request: NewsRequest): Data<NewsResponse> {
        delay(1000)

        return suspendCoroutine {
            if (request.page < 1) {
                val response = Gson().fromJson(
                    errorPageCannotBeLessThanOne,
                    NewsResponse::class.java
                )

                it.resume(Data(
                    isError = response.isError(),
                    message = response.message ?: "",
                    result = response
                ))

                return@suspendCoroutine
            }

            val response = Gson().fromJson(
                resultOk,
                NewsResponse::class.java
            )

            it.resume(Data(
                isError = response.isError(),
                message = response.message ?: "",
                result = response
            ))
        }
    }

    private val errorPageCannotBeLessThanOne = "{\n" +
            "    \"status\": \"error\",\n" +
            "    \"code\": \"pageCannotBeLessThanOne\",\n" +
            "    \"message\": \"The page parameter cannot be less than 1. You have requested 20.\"\n" +
            "}"

    private val resultOk = "{\n" +
            "    \"status\": \"ok\",\n" +
            "    \"totalResults\": 1559,\n" +
            "    \"articles\": [\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Kate Clark\",\n" +
            "            \"title\": \"Startups Weekly: Spotify gets acquisitive and Instacart screws up\",\n" +
            "            \"description\": \"This week in startups: Turvo takes center stage, a mental health unicorn emerges and Reddit rakes in cash.\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/09/startups-weekly-spotify-gets-acquisitive-instacart-screws-up-and-scooters-crash/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/GettyImages-1066124208.jpg?w=600\",\n" +
            "            \"publishedAt\": \"2019-02-09T13:02:17Z\",\n" +
            "            \"content\": \"Did anyone else listen to season one of StartUp, Alex Blumberg’s OG Gimlet podcast? I did, and I felt like a proud mom this week reading stories of the major, first-of-its-kind Spotify acquisition of his podcast production company, Gimlet. Spotify also bought… [+5696 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Anthony Ha\",\n" +
            "            \"title\": \"Appleは最新のコマーシャルでアリアナ・グランデなど人気ミュージシャンをミー文字にした\",\n" +
            "            \"description\": \"<span class=\\\"embed-youtube embed breakout embed--video\\\" style=\\\"text-align:center;display:block;\\\"></span>\\r\\n\\r\\nグラミー賞の時期に合わせてApple Musicが、3つの新しいコマーシャルを披露した。それぞれ、Ariana Grande（アリアナ・グランデ）、Khalid（カリード）、そしてFlorida Georgia Line（フロリダ・ジョージア・ライン）のニューシングルをフィーチャーしている。\\r\\n\\r\\n各…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-08-apple-memoji-ads/\",\n" +
            "            \"urlToImage\": \"https://s2.wp.com/wp-content/themes/vip/techcrunch-jp-2015/assets/images/techcrunch.global.thumb-placeholder.png\",\n" +
            "            \"publishedAt\": \"2019-02-09T09:54:00Z\",\n" +
            "            \"content\": \"Apple Music3Ariana GrandeKhalidFlorida Georgia Line\\r\\n(Memoji)(Animoji)\\r\\nAppleChildish GambinoMigos\\r\\nThe Verge“”\\r\\n: Apple\\r\\n[]iwatani(a.k.a. hiwa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Jon Russell\",\n" +
            "            \"title\": \"Operaの無料VPNがAndroid上のブラウザーアプリに登場、ネイティブアプリは復活せず\",\n" +
            "            \"description\": \"Operaは<a target=\\\"_blank\\\" href=\\\"http://jp.techcrunch.com/2016/04/21/20160420opera-brings-built-in-vpn-service-to-its-browser/\\\" rel=\\\"noopener noreferrer\\\">VPNをバンドル</a>した初のブラウザーだが、今度はその努力をモバイルに広げようとしている。\\r\\n\\r\\n同社の今日（米国時間2/8）の<a target=\\\"_blank\\\" href=\\\"https://blogs.op…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-08-opera-android-vpn/\",\n" +
            "            \"urlToImage\": \"https://techcrunchjp.files.wordpress.com/2019/02/opera-ipo-2.jpg?w=1024\",\n" +
            "            \"publishedAt\": \"2019-02-09T05:13:26Z\",\n" +
            "            \"content\": \"OperaVPN\\r\\n2/8AndroidVPNVPN“optimal”VPNonOpera\\r\\nVPN\\r\\nOperaAndroidiOSVPNiOS\\r\\n: “VPNAndroid”Nasdaq\\r\\nOperaVPN2015Web 3\\r\\nOpera“Touch”AndroidiOS\\r\\n[]iwatani(a.k.a. hiwa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Sarah Perez\",\n" +
            "            \"title\": \"タイムラインの整理に役立つ「こんまりインスパイア」Twitterツール登場\",\n" +
            "            \"description\": \"<p id=\\\"speakable-summary\\\">あなたのTwitterタイムラインは「ときめいて」いるだろうか？多くのユーザーにとっては、おそらくそうではないだろう。多分何年にもわたって、あなたは少しずつ丁寧にTwitterアカウントのフォローを増やし、それは数え切れないほどの数となって、いまやそもそもなぜフォローをしたのか思い出せないひとたちからの、脈絡のないツイートでタイムラインが埋められていることだろう。そんなとき、新しいTwitterツール、<a target=\\\"_blank\\\" href=\\\"https…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-05-this-marie-kondo-inspired-twitter-tool-will-help-you-declutter-your-timeline-so-it-again-sparks-joy/\",\n" +
            "            \"urlToImage\": \"https://techcrunchjp.files.wordpress.com/2019/02/twitter-logo.jpg?w=800\",\n" +
            "            \"publishedAt\": \"2019-02-09T03:00:45Z\",\n" +
            "            \"content\": \"TwitterTwitterTwitterTokimeki Unfollow\\r\\nFacebookBranchJulius Tarng”tokimeki””spark joy”TarngNetflixKonMari”Tidying Up”KonMari KonMariKonMari\\r\\nTwitter\\r\\nTokimeki Unfollow\\r\\ncookieGlitch\\r\\nTwitter\\r\\n”KonMari” “konmari” \\r\\nOldest firstNewest first/\\r\\nspark joy\\r\\nTwitte… [+277 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Zack Whittaker\",\n" +
            "            \"title\": \"密かに画面を録画する有名なiPhoneアプリ\",\n" +
            "            \"description\": \"<img class=\\\"aligncenter wp-image-259304 size-full\\\" src=\\\"https://techcrunchjp.files.wordpress.com/2019/02/screenshots.jpg\\\" alt=\\\"\\\" width=\\\"940\\\" height=\\\"465\\\" />\\r\\n\\r\\nAir Canada、Hollister、Expediaなどの大手企業は、iPhoneのアプリ上のすべてのタップやスワイプ操作を記録している。ほとんどの場合、ユーザーはそれに気付かない。彼らは許可を…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-06-iphone-session-replay-screenshots/\",\n" +
            "            \"urlToImage\": \"https://techcrunchjp.files.wordpress.com/2019/02/screenshots.jpg?w=940\",\n" +
            "            \"publishedAt\": \"2019-02-09T03:00:40Z\",\n" +
            "            \"content\": \"Air CanadaHollisterExpediaiPhone\\r\\nTechCrunch\\r\\nAbercrombie FitchHotels.comSingapore AirlinesGlassbox\\r\\nGlassboxWeb\\r\\nThe App AnalystAir CanadaiPhoneAir Canada\\r\\nAir CanadaThe App AnalystTechCrunch\\r\\nThe App AnalystGlassboxWebCharles Proxy\\r\\nGlassbox\\r\\nGlassboxThe Ap… [+480 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Ron Miller\",\n" +
            "            \"title\": \"バックアップ/リカバリーサービスのCarboniteがエンドポイントセキュリティのWebrootを買収\",\n" +
            "            \"description\": \"ボストンでオンラインのバックアップとリカバリーサービスを提供している<a target=\\\"_blank\\\" href=\\\"http://carbonite.com\\\" rel=\\\"noopener noreferrer\\\">Carbonite</a>が昨日（米国時間2/7）、エンドポイントセキュリティのベンダー<a target=\\\"_blank\\\" href=\\\"http://webroot.com\\\" rel=\\\"noopener noreferrer\\\">Webroot</a>をキャッシュ6億1850万ドルで買収する、と発表した…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-08-carbonite-to-acquire-endpoint-security-company-webroot-for-618-5m/\",\n" +
            "            \"urlToImage\": \"https://techcrunchjp.files.wordpress.com/2019/02/gettyimages-135205598.jpg?w=1024\",\n" +
            "            \"publishedAt\": \"2019-02-09T02:47:22Z\",\n" +
            "            \"content\": \"Carbonite2/7Webroot61850\\r\\nWebrootWebroot1997CarboniteWebroot201825000Carbonite29640\\r\\nCarboniteCEOMohamad Ali: “(threat intelligence, )”\\r\\nCarboniteCarbonite(VARs)Webroot14000(MSPs)MSPCarboniteWebroot30\\r\\nCarbonite114500DellMozy\\r\\n: Carbonite\\r\\nBarclaysCitizens Ba… [+48 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Brian Heater\",\n" +
            "            \"title\": \"Amazonはニューヨークの第二本社を考えなおしているかもしれない\",\n" +
            "            \"description\": \"第二本社をニューヨークに開くというAmazonの決定は、最初から<a target=\\\"_blank\\\" href=\\\"https://techcrunch.com/2019/01/30/nyc-council-questions-tax-breaks-and-economic-impact-of-amazon-hq2/\\\" rel=\\\"noopener noreferrer\\\">異論が多かった</a>。同社はおよそ25000の雇用創出を掲げていたが、市民や地元の行政は、暗黙で約束されている税の優遇措置や住宅問題、老朽化して…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-08-amazon-may-be-rethinking-its-new-york-city-headquarters/\",\n" +
            "            \"urlToImage\": \"https://techcrunchjp.files.wordpress.com/2019/02/dyk58wbxqaeqnu4.jpg?w=1024\",\n" +
            "            \"publishedAt\": \"2019-02-09T01:31:55Z\",\n" +
            "            \"content\": \"Amazon25000\\r\\nAmazonBezosWashington Post\\r\\n“”“”\\r\\nAmazonAmazonAlexandria Ocasio-Cortez\\r\\nAmazon\\r\\n: Amazon: “”\\r\\n:12\\r\\n[]iwatani(a.k.a. hiwa\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Devin Coldewey\",\n" +
            "            \"title\": \"Feel the beep: This album is played entirely on a PC motherboard speaker\",\n" +
            "            \"description\": \"If you're craving a truly different sound with which to slay the crew this weekend, look no further than System Beeps, a new album by shiru8bit — though you may have to drag your old 486 out of storage to play it. Yes, this album runs in MS-DOS and its music …\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/feel-the-beep-this-album-is-played-entirely-on-a-pc-motherboard-speaker/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/sysbeep.jpg?w=632\",\n" +
            "            \"publishedAt\": \"2019-02-09T00:33:48Z\",\n" +
            "            \"content\": \"If you’re craving a truly different sound with which to slay the crew this weekend, look no further than System Beeps, a new album by shiru8bit though you may have to drag your old 486 out of storage to play it. Yes, this album runs in MS-DOS and its music is… [+2630 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Devin Coldewey\",\n" +
            "            \"title\": \"Jeff Bezos、「タブロイド紙の脅迫」を公開して非難\",\n" +
            "            \"description\": \"<a target=\\\"_blank\\\" href=\\\"https://crunchbase.com/organization/amazon\\\" rel=\\\"noopener noreferrer\\\"><b>Amazon</b></a><span style=\\\"font-weight:400;\\\">のCEO、</span><span style=\\\"font-weight:400;\\\">Jeff Bezosは自身のヌード写真を盾にAMIから脅迫を受けていることを明らかにした。AMIはタブロイド紙National Enquirerの…\",\n" +
            "            \"url\": \"https://jp.techcrunch.com/2019/02/09/2019-02-07-jeff-bezos-accuses-national-enquirer-of-blackmailing-him-and-publishes-the-details-himself/\",\n" +
            "            \"urlToImage\": \"https://techcrunchjp.files.wordpress.com/2019/02/bezos.jpg?w=1024\",\n" +
            "            \"publishedAt\": \"2019-02-09T00:15:07Z\",\n" +
            "            \"content\": \"AmazonCEOJeff BezosAMIAMINational Enquirer“vs”\\r\\nBezosMediumAMI\\r\\nBezosGavin de BeckerNational EnquirerBezosBezos\\r\\nAMICEODavid Pecker\\r\\nAMIPecker“”\\r\\nBezosAMIBezos\\r\\nAMIBezosAMIBezosAMIBezos\\r\\nAMIAmazonBezosBezos\\r\\nBezos“”90\\r\\nBezosBezosAMIAMIBezos\\r\\nAMIBezos\\r\\n“”……107… [+50 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Kirsten Korosec\",\n" +
            "            \"title\": \"Transportation Weekly: Amazon’s secret acquisition and all the AV feels\",\n" +
            "            \"description\": \"Welcome to Transportation Weekly; I’m your host Kirsten Korosec, senior transportation reporter at TechCrunch. I cover all the ways people and goods move from Point A to Point B — today and in the future — whether it’s by bike, bus, scooter, car, train, truck…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/transportation-weekly-amazons-secret-acquisition-and-all-the-av-feels/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/E-Golf_1_Angle.jpg?w=711\",\n" +
            "            \"publishedAt\": \"2019-02-08T22:32:55Z\",\n" +
            "            \"content\": \"Welcome to Transportation Weekly; I’m your host Kirsten Korosec, senior transportation reporter at TechCrunch. I cover all the ways people and goods move from Point A to Point B today and in the future whether it’s by bike, bus, scooter, car, train, truck, ro… [+12245 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Kirsten Korosec\",\n" +
            "            \"title\": \"Waymo CTO on the company’s past, present and what comes next\",\n" +
            "            \"description\": \"A decade ago, about a dozen or so engineers gathered at Google’s main Mountain View campus on Charleston Road to work on Project Chauffeur, a secret endeavor housed under the tech giant’s moonshot factory X. Project Chauffeur — popularly know as the “Google s…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/waymo-cto-on-the-companys-past-present-and-what-comes-next/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/01/waymo-google-10-years.png?w=753\",\n" +
            "            \"publishedAt\": \"2019-02-08T22:23:16Z\",\n" +
            "            \"content\": \"A decade ago, about a dozen or so engineers gathered at Google’s main Mountain View campus on Charleston Road to work on Project Chauffeur, a secret endeavor housed under the tech giant’s moonshot factory X.\\r\\nProject Chauffeur popularly know as the “Google se… [+14278 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Devin Coldewey\",\n" +
            "            \"title\": \"Facebook picks up retail computer vision outfit GrokStyle\",\n" +
            "            \"description\": \"If you've ever seen a lamp or chair that you liked and wished you could just take a picture and find it online, well, GrokStyle let you do that — and now the company has been snatched up by Facebook to augments its own growing computer vision department.\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/facebook-picks-up-retail-computer-vision-outfit-grokstyle/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/grokstyle.jpg?w=637\",\n" +
            "            \"publishedAt\": \"2019-02-08T22:05:42Z\",\n" +
            "            \"content\": \"If you’ve ever seen a lamp or chair that you liked and wished you could just take a picture and find it online, well, GrokStyle let you do that and now the company has been snatched up by Facebook to augment its own growing computer vision department.\\r\\nGrokSt… [+1733 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Megan Rose Dickey\",\n" +
            "            \"title\": \"Lyft says it has more wheelchair accessible vehicles available in NYC\",\n" +
            "            \"description\": \"Lyft, which has faced at least one lawsuit pertaining to its alleged discrimination against people with physical abilities, announced today it has expanded its wheelchair-accessible vehicle (WAV) service in New York City. Details on the blog are very scarce (…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/lyft-wheelchair-accessible-vehicles-available-in-nyc/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/GettyImages-931816870.jpg?w=600\",\n" +
            "            \"publishedAt\": \"2019-02-08T21:27:14Z\",\n" +
            "            \"content\": \"Lyft, which has faced at least one lawsuit pertaining to its alleged discrimination against people with physical abilities, announced today it has expanded its wheelchair-accessible vehicle (WAV) service in New York City. Details on the blog are very scarce (… [+2163 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Jonathan Shieber\",\n" +
            "            \"title\": \"FDA chief summons Altria and JUUL to Washington to discuss teen vaping\",\n" +
            "            \"description\": \"The head of the U.S. Food and Drug Administration is calling Altria and Juul to meet in Washington to discuss their tie-up and how it impacts the companies’ plans to combat teen vaping. Earlier this year, Altria invested \$12.8 billion investment in Juul. “Aft…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/fda-chief-summons-altria-and-juul-to-washington-to-discuss-teen-vaping/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2018/12/GettyImages-997165918.jpg?w=599\",\n" +
            "            \"publishedAt\": \"2019-02-08T19:55:09Z\",\n" +
            "            \"content\": \"The head of the U.S. Food and Drug Administration is calling Altria and Juul to meet in Washington to discuss their tie-up and how it impacts the companies’ plans to combat teen vaping. Earlier this year, Altria  href=\\\"https://techcrunch.com/2018/12/20/juul-l… [+2654 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Lucas Matney\",\n" +
            "            \"title\": \"Athenascope nabs \$2.5M seed led by First Round to bring gamers AI-edited highlight reels\",\n" +
            "            \"description\": \"As massive cross-platform gaming titles become even larger time-sucks for a lot of people, it’s probably worth reflecting on how to savor your in-game accomplishments. Streaming of eSports celebrities on sites like Twitch has taken off like no one imagined, b…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/athenascope-nabs-2-5m-seed-led-by-first-round-to-bring-gamers-ai-edited-highlight-reels/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2018/07/fortnite02.jpg?w=711\",\n" +
            "            \"publishedAt\": \"2019-02-08T19:37:55Z\",\n" +
            "            \"content\": \"As massive cross-platform gaming titles become even larger time-sucks for a lot of people, it’s probably worth reflecting on how to savor your in-game accomplishments.\\r\\nStreaming of eSports celebrities on sites like Twitch has taken off like no one imagined, … [+2778 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Sarah Perez\",\n" +
            "            \"title\": \"‘Amazon Live’ is the retailer’s latest effort to take on QVC with live-streamed video\",\n" +
            "            \"description\": \"Amazon is taking on QVC with the launch of Amazon Live, which features live-streamed video shows from Amazon talent as well as those from brands that broadcast their own live streams through a new app, Amazon Live Creator. On the live shows, hosts talk about …\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/amazon-live-is-the-retailers-latest-effort-to-take-on-qvc-with-live-streamed-video/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/Screen-Shot-2019-02-08-at-12.56.47-PM.png?w=715\",\n" +
            "            \"publishedAt\": \"2019-02-08T19:07:43Z\",\n" +
            "            \"content\": \"Amazon is taking on QVC with the launch of Amazon Live, which features live-streamed video shows from Amazon talent as well as those from brands that broadcast their own live streams through a new app, Amazon Live Creator. On the live shows, hosts talk about … [+5223 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Kirsten Korosec\",\n" +
            "            \"title\": \"One of Tesla’s biggest investors upped its stake by more than \$30M\",\n" +
            "            \"description\": \"Baillie Gifford  & Co., the second-biggest shareholder of Tesla stock and the , has increased its stake in the electric automaker and energy storage company. A regulator filing posted Friday shows Baillie increased its stake in Tesla from 7.64 percent at the …\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/one-of-teslas-biggest-investors-upped-its-stake-by-more-than-30m/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2018/10/GettyImages-1044441350.jpeg?w=601\",\n" +
            "            \"publishedAt\": \"2019-02-08T18:59:39Z\",\n" +
            "            \"content\": \"Baillie Gifford  &amp; Co., the second-biggest shareholder of Tesla stock and the , has increased its stake in the electric automaker and energy storage company.\\r\\nA regulator filing posted Friday shows Baillie increased its stake in Tesla from 7.64 percent at… [+1598 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Romain Dillet\",\n" +
            "            \"title\": \"OakNorth raises \$440 million from SoftBank and Clermont\",\n" +
            "            \"description\": \"British startup OakNorth has raised a \$440 million funding round from SoftBank’s Vision Fund as well as the Clermont Group. The company is creating a digital bank and focuses on loans for small and medium enterprises and the technology behind those loans. Tod…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/oaknorth-raises-440-million-from-softbank-and-clermont/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/rawpixel-741658-unsplash.jpg?w=599\",\n" +
            "            \"publishedAt\": \"2019-02-08T18:26:31Z\",\n" +
            "            \"content\": \"British startup OakNorth has raised a \$440 million funding round from SoftBanks Vision Fund as well as the Clermont Group. The company is creating a digital bank and focuses on loans for small and medium enterprises and the technology behind those loans.\\r\\nTod… [+1211 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Ron Miller\",\n" +
            "            \"title\": \"Carbonite to acquire endpoint security company Webroot for \$618.5M\",\n" +
            "            \"description\": \"Carbonite, the online backup and recovery company based in Boston, announced late yesterday that it will be acquiring Webroot, an endpoint security vendor, for \$618.5 million in cash. The company believes that by combining its cloud backup service with Webroo…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/carbonite-to-acquire-endpoint-security-company-webroot-for-618-5m/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/GettyImages-135205598.jpg?w=600\",\n" +
            "            \"publishedAt\": \"2019-02-08T18:08:13Z\",\n" +
            "            \"content\": \"Carbonite, the online backup and recovery company based in Boston, announced late yesterday that it will be acquiring Webroot, an endpoint security vendor, for \$618.5 million in cash.\\r\\nThe company believes that by combining its cloud backup service with Webro… [+1817 chars]\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"source\": {\n" +
            "                \"id\": \"techcrunch\",\n" +
            "                \"name\": \"TechCrunch\"\n" +
            "            },\n" +
            "            \"author\": \"Brian Heater\",\n" +
            "            \"title\": \"Amazon may be rethinking its New York City headquarters\",\n" +
            "            \"description\": \"Amazon’s decision to open HQ2 in New York City has been a controversial decision since day one. The company has been championing the estimated 25,000 jobs the move could bring to the metropolitan area, while citizens and local government officials have balked…\",\n" +
            "            \"url\": \"http://techcrunch.com/2019/02/08/amazon-may-be-rethinking-its-new-york-city-headquarters/\",\n" +
            "            \"urlToImage\": \"https://techcrunch.com/wp-content/uploads/2019/02/DyK58WbXQAEQNU4.jpg?w=533\",\n" +
            "            \"publishedAt\": \"2019-02-08T18:01:59Z\",\n" +
            "            \"content\": \"Amazons decision to open HQ2 in New York City has been a controversial decision since day one. The company has been championing the estimated 25,000 jobs the move could bring to the metropolitan area, while citizens and local government officials have balked … [+1236 chars]\"\n" +
            "        }\n" +
            "    ]\n" +
            "}"
}