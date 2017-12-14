package pl.martapiatek.confapp.repository;


import android.content.Context;

import pl.martapiatek.confapp.ConfAppDbAdapter;

public class SpeakerRepository {


    private ConfAppDbAdapter mDbAdapter;
    private Context context;


    public SpeakerRepository(Context context) {
        this.context = context;
        mDbAdapter = new ConfAppDbAdapter(this.context);
    }

    public ConfAppDbAdapter openDb() {

        mDbAdapter.open();
        return mDbAdapter;
    }
    public void insertSpeakers(ConfAppDbAdapter mDbAdapter) {

        mDbAdapter.createSpeaker("Andrzej Ludwikowski",
                "Software Journeyman @ SoftwareMill",
                "Miller at SoftwareMill. A devotee of DDD, Event Sourcing and Polyglot Persistence. Continuously chasing the dream of a perfect software architecture, fulfilling all of the requirements and trends, even the strangest ones.");

        mDbAdapter.createSpeaker("Ryan Townsend",
                "CTO @ Shift Commerce",
                "With over 15 years experience developing for the web, and an undying passion for web performance, Ryan Townsend is the CTO of Shift Commerce – a SaaS e-commerce platform bringing agility to mid-to-enterprise retailers. His pragmatic and performance-led outlook means that—on the rare occasion that he does wear a shirt—his sleeves stay firmly rolled up: even as an exec, his favourite place is right there in the thick of things with his team. Outside of the office, you’ll usually find him picking up heavy objects in the gym or falling off his mountain bike down the side of a hill.");

        mDbAdapter.createSpeaker("Matteo Collina",
                "Principal Architect @ nearForm",
                "Matteo is a code pirate and mad scientist. He spends most of his days programming in Node.js, but in the past he worked with Ruby, Java and Objective-C. In 2014, he defended his Ph.D. thesis titled \"Application Platforms for the Internet of Things\". Now he is a Software Architect at nearForm, where he consults for the top brands of the world. Matteo is also the author of the Node.js MQTT Broker, Mosca, the fast logger Pino and of the LevelGraph database. Matteo is also a member of the Node.js Technical Steering Committee. Matteo spoke at several international conferences: Node.js Interactive, NodeConf.eu, NodeSummit, LXJS, Distill by Engine Yard, and JsDay to name a few. He is also co-author of the book \"Javascript: Best Practices\" edited by FAG, Milan. In the summer he loves sailing the Sirocco.");

        mDbAdapter.createSpeaker("Mohamed Taman",
                "Enterprise Architect / Innovation & R&D Sr. Manager @ e-finance",
                "Enterprise Architect / Innovation, R&D Sr. Manager @e-finance. A frequent consultant with 16+ years' experience in Java and Software industry. A Java Champion, IoT / Mobile/ Web / Big Data / Cloud / Blockchain / DevOps Architect, JCP, 2013-2015 Duke Award winner 3 times, 2013 JCP award winner, International Speaker. Authored a “JavaFX essential” book, \"Mastering Java SE 9\" video training for Packt and LinkedIn Learning (Lynda), a technical reviewer of “Getting Started with Oracle Public Cloud” book for Packt Publishing.");

        mDbAdapter.createSpeaker("Vladimir Alekseichenko",
                "Machine Learning Trainer/Architect @ DataWorkshop",
                "Vladimir is Artificial Intelligence enthusiast. Perfectionist in the heart and pragmatic in the mind. Vladimir likes traveling (visited about 30 countries). He worked in different areas in IT (with different technologies, including php and javascript) in last 10 years. The last 4 years he spends his time on learning and getting insights from the data. He was involved in building infrastructure for Search Engine (TB's data), Big Data things. He prepared an ETL (based on Hadoop/Kafaka/Storm stuff) and he made data prediction (sales forecasting) and many others. He is a trainer at DataWorkshop.eu where he explains how to use a machine learning in a real life without theoretical complications. He has a podcast about Artificial Intelligence - BiznesMysli.pl (in Polish). He is an architect at General Electric. He participates in Kaggle's competitions. He loves (data) and challenges.");


        mDbAdapter.createSpeaker("Luciano Mammino",
                "Principal Application Engineer @ Planet 9 Energy",
                "I am a software engineer born in 1987, the same year that “Super Mario Bros” was released in Europe, which, by chance is my favourite game! I started coding early at the age of 12, hacking away with my father's old i386 armed only with MS-DOS and the QBasic interpreter and I have been professionally a software developer for more than 10 years. I am currently a Principal Application Engineer at Planet 9 Energy in Dublin where I have been using the Serverless paradigm for more than 1 year to power up the next-gen electricity provider for the UK market. I am also a passionate fullstack Node.js developer and I co-authored the book Node.js design patterns 2nd edition (Packt). To help other full stack developers to stay up to date and motivated I recently launched Fullstack Bulletin, a semi-automated weekly newsletter, also completely open source and built on top of serverless services.");


        mDbAdapter.createSpeaker("Tess Ferrandez",
                "Developer Evangelist @ Microsoft",
                "Tess is a developer and developer evangelist at Microsoft. She has a long background in .net development and analytics/debugging, and is equally happy developing beautiful algorithms as she is developing sweet User Interfaces. She has been blogging at her site for the better part of her career, and spoken at lots and lots of conferences around the world.");

        mDbAdapter.createSpeaker("Chris Klug",
                "Ninja @ tretton37",
                "Chris Klug is a developer badass-as-a-service that either creates or solves problems depending on who you ask. He loves creating and building things. Whether it be a new application, a new kitchen or a new RC helicopter, you will see him building things all the time. Most of the time, that means writing code and solving problems for clients at a company called tretton37 in Stockholm though. Except for the many days he spends at conferences and usergroups, talking about doing things he is passionate about, and for the days he goes mountain biking, IPSC shooting, kiteboarding or RC helicopter flying.");

        mDbAdapter.createSpeaker("Philippe De Ryck",
                "Web security expert @ DistriNet, KU Leuven",
                "Philippe runs the Web Security Training program at the DistriNet Research Group, KU Leuven. Through practical, hands-on training, Philippe teaches about relevant threats, current state-of-practice security technologies, and upcoming technologies to keep an eye on.");

        mDbAdapter.createSpeaker("Harry Roberts",
                "Founder @ CSS Wizardry Ltd.",
                "With a client list including Google, Unilever, and the United Nations, Harry is an award-winning Consultant Front-end Architect who helps organisations and teams across the globe to plan, build, and maintain product-scale UIs. A Google Developer Expert, he writes on the subjects of CSS architecture, performance, and scalability at csswizardry.com, develops and maintains inuitcss, authored CSS Guidelines, and Tweets at @csswizardry.");

        mDbAdapter.createSpeaker("Stephen Haunts",
                "Head of Development @ Buying Butler Ltd",
                "Stephen Haunts is the Head of Development for Buying Butler Ltd and RightIndem Ltd in the United Kingdom where he runs multiple development teams building products for the global insurance industry and online car sales marketplace. He is also an experienced software developer with a focus on .NET technologies and security for back end enterprise systems. He is also a Pluralsight author, blogger atwww.stephenhaunts.com and international conference speaker, speaking at events like NDC London, NDC Oslo, Techorama, SDD Conf and Code Europe. He also co runs a user group calledDerbyshire Dot Net.");

        mDbAdapter.createSpeaker("Kalin Maldzhanski",
                "Maker @ Linked.Farm",
                "Kalin is a freelance consultant @AppTik and Co-Founder @Linked.Farm, IoT&DIY enthusiast, Open Data Advocate, Open Source contributor. He loves technology, automation, optimization and confrontation. He has a great passion for Android, REST APIs, Open Linked Data and distributed systems.");

        mDbAdapter.createSpeaker("Simona Cotin",
                "Software Engineer @ Arista Networks",
                "Simona is enthusiastic about everything data related. She has a background in computer science and extensive experience in building data analytics platforms. Communities power her up and that's why you can always find her co-organizing or attending meetups in Dublin. Passionate about knowledge sharing, she has also worked on workshops for Women Who Code in Dublin and NgGirls in Copenhagen encouraging women to learn about programming.");

        mDbAdapter.createSpeaker("Sebastian Malaca",
                "Senior Software Developer @ UBS",
                "Sebastian is an experienced and dedicated software engineer specializing in object-oriented design and programming, software architecture, code quality and agile. His interests include testing, programming, software engineering and agile software craftsmanship. He's also a speaker (JDD, GeeCon, Confitura, Devoxx, etc.), writer and contributor to several blogs (DZone, JavaCodeGeeks) about Software Development and Agile Software Craftsmanship.");

        mDbAdapter.createSpeaker("Nicolai Parlog",
                "Freelancer @ CodeFX",
                "Java developer, blogger, author, YouTuber, trainer");

        mDbAdapter.createSpeaker("Vitaliy Rudnytskiy",
                "Principal Architect @ SAP",
                "Vitaliy is a Principal Architect at SAP, where he is involved into development of SAP Developer Center (http://developers.sap.com). His main interest is in Big Data and Fast Data solutions, IoT, Analytics and Data Visualizations. He graduated from University of Technologies in Wrocław, Poland. Before joining SAP he spent 10 years working as a technology consultant in Europe and in the US. In 2010 he has been invited to a prestigious group of SAP Mentors – the community of top influencers in SAP ecosystem.");

        mDbAdapter.createSpeaker("Andrei Gordienkov",
                "Senior IT Architect @ Volvo",
                "Andrei is an architect that still coding on .NET. Passionated about AOP, infected by TDD and \"automate all the things\" possibly because of the great laziness. He is also IT Trainer at Luxoft PTC with topics about arhitecture, patterns, refactorings and other dev things, speaker at conferences and organizer as well. Constantly challange colleagues against the \"Least astonishment principle\" for API.");

        mDbAdapter.createSpeaker("Eugene Petrenko",
                "Developer @ JetBrains",
                "Eugene is a software developer and holds Ph.D. in Computer Science. Passionate about programming, languages, technologies and making this world better. Working at JetBrains and contributing to many own and open source projects. He also speaks Java, Kotlin, Go, .NET, Web and native code.");

    /*    mDbAdapter.createSpeaker("",
                "",
                "");

*/

    }





}
