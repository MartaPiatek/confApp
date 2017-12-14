package pl.martapiatek.confapp.repository;

import android.content.Context;
import android.util.Log;

import pl.martapiatek.confapp.ConfAppDbAdapter;
import pl.martapiatek.confapp.ConfAppSimpleCursorAdapter;

public class EventRepository {

    private ConfAppDbAdapter mDbAdapter;
    private Context context;


    public EventRepository(Context context) {
        this.context = context;
        mDbAdapter = new ConfAppDbAdapter(this.context);
    }

    public ConfAppDbAdapter openDb() {

        mDbAdapter.open();
        return mDbAdapter;
    }


    public void insertEvents(ConfAppDbAdapter mDbAdapter) {

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Performance tests with Gatling",
                "Performance tests are a tough topic, especially nowadays with micro services architectures, clusters and very complex systems. In the first part of the presentation, I would like to address the most common problems and errors in this area. Share my experiences often gained by frustrating failures and demanding experiments. After this lovely introduction, I will show you - why it's worth to spend some time and learn a new tool for integrating and performance test such as Gatling? - under what circumstances it will be extremely useful to have it in your toolbox? - what are Gatling cons and what kind of problems can you expect?",
                "Andrzej Ludwikowski");

        mDbAdapter.createEvent("2017-12-12", "B-2 aud. 100",
                "Have your cake and eat it – an introduction to event-driven architecture",
                "Every day we lose data. Not by accident or disaster, but by implementation. However, unlike cake, we can keep our data as we consume and act upon it. This talk is an introduction to event-driven architecture. We’ll learn how to implement event sourcing; revealing intent, decoupling our microservices and even allowing us to time-travel and change history when fixing bugs. We’ll be simultaneously making our lives easier as developers whilst better supporting the growth of our businesses – it doesn’t get much better than that, does it?",
                "Ryan Townsend");

        mDbAdapter.createEvent("2017-12-12", "B-2 aud. 100",
                "The Cost of Logging",
                "Sunday morning and your phone rings: production is down. After two hours, you manage to solve it: you could have fixed it in one minute if you had the right information from the start. First thing in the morning, you add logging everywhere, to avoid this issue and be able to triage and solve problems easily. Now your application requires twice as many servers to cater to the same demand. Matteo Collina talk about building Pino, a JSON logger for Node.js that’s up to 17 times faster than pre-existing loggers, with a growing ecosystem of support libraries, including high performance integration with Express, Hapi, Koa and Restify. How did we make it so fast? After showing what Pino can do, we demonstrate our tooling: 0x for flamegraphs, and autocannon for HTTP/1.1 benchmarking. Then we’ll discuss V8 optimizing compilers, string flattening and other mad-science optimizations that we embedded inside Pino.",
                "Matteo Collina");

        mDbAdapter.createEvent("2017-12-14", "B-2 aud. 100",
                "Android Mobile Development, powered by Java SE 8 & Kotlin",
                "If you are an Android developer, an experienced Java developer looking to take your mobile applications to the next level, so this session is for you. Starting from Android N which is the next version of Google's blockbuster operating system for mobile devices. Developers can experiment with the new features and capabilities of the operating system powered by Java SE 8, I will also touch the new Jack and Jill compiler toolchain and the new Desugar compiler designed for Java\u200B SE 8 support and programming with Java SE 8 syntax; lambda expression, method reference, default methods, Streams... etc. So, what are you waiting for?! Click to enroll.",
                "Mohamed Taman");

        mDbAdapter.createEvent("2017-12-14", "B-2 aud. 100",
                "Practical Machine Learning For Programmers",
                "Vladimir Alekseichenko",
                "Are you programmer? Might you are wondering what does machine learning mean from practical point of view. And you have no idea how to start? Or even worse, it looks so complicated to you? Hm... i had the same observations when I started my journey in machine learning world. Let me show you machine learning from other side. Why should you card about ML? For today, ML has a big impact on our world. About 30 billions have been invest in AI in 2016 and this number only increase in next years. EU market needs about 11 millions in 2020 (almost x2 more than few years ago) specialists related with data. The market needs people who can build and understand machine learning model in real life (not only in labs). During a presentation, i'll show you how a machine learning process looks like. What is a deep learning and how you can apply it? What is convolutional neural network. And how transfer learning can simplify your life. You'll see the (python) code. And during or after presentation you can repeat it by yourself (demo will be available on GitHub).");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "A developers guide to Machine Learning",
                "Machine Learning is one of the fastest growing areas of computer science. Are you curious about Machine Learning, but think it just seems like too big of a mountain to climb? This talk is a beginners guide to machine learning and data science. We will cover everything from getting and massaging the data to publishing your model. You won't leave an expert data scientist but you will definitely be off to a running start.",
                "Tess Ferrandez");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Building a serverless company on AWS lambda and Serverless framework",
                "Planet9energy.com is a new electricity company building a sophisticated analytics and energy trading platform for the UK market. Since the earliest draft of the platform, we took the unconventional decision to go serverless and build the product on top of AWS Lambda and the Serverless framework using Node.js. In this talk, I want to discuss why we took this radical decision, what are the pros and cons of this approach and what are the main issues we faced as a tech team in our design and development experience. We will discuss how normal things like testing and deployment need to be re-thought to work on a serverless fashion but also the benefits of (almost) infinite self-scalability and the peace of mind of not having to manage hundreds of servers. Finally, we will underline how Node.js seems to fit naturally in this scenario and how it makes developing serverless applications extremely convenient.",
                "Luciano Mammino");

        mDbAdapter.createEvent("2017-12-15", "B-2 aud. 100",
                "The whirlwind tour of Authentication and Authorization with ASP.NET Core",
                "Chris Klug",
                "Authentication and authorization is not a fun topic for most people. It is generally that thing that has to be there, but nobody really cares about. And on top of that, every time the requirements are a little different. And every time we have to figure out how to write all the plumbing to get it done properly. It is security after all… In ASP.NET Core, Microsoft has made it fairly easy to get it all done. In most cases, it is only a few lines of code and some minor configuration, and you are up going. However, if you don’t know the lines of code and the config, it can be hard. In this presentation, you will see a whole heap of different types of authN and authZ being configured and used. There will be social logins, local logins, AD-based logins, and even token based authentication for SPAs. Basically, everything you need to get up and running when it comes to authenticating your users in ASP.NET Core.");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Common API security pitfalls",
                "The shift towards an API landscape indicates a significant evolution in the way we build applications. The rise of JavaScript and mobile applications have sparked an explosion of easily-accessible REST APIs. But how do you protect access to your API? Which security aspects are no longer relevant? Which security features are an absolutely must-have, and which additional security measures do you need to take into account? These are hard questions, as evidenced by the deployment of numerous insecure APIs. Attend this session to find out about common API security pitfalls, that often result in compromised user accounts and unauthorized access to your data. We expose the problem that lies at the root of each of these pitfalls, and offer actionable advice to address these security problems. After this session, you will know how to assess the security of your APIs, and the best practices to improve them towards the future.",
                "Philippe De Ryck");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Trade Secrets – Little-Known Performance Tools (and How to Use Them)",
                "Building fast websites becomes a lot easier when you have the right tools, but which tools are they? What should we be using? You probably know your way around DevTools already, which is a great start, but there are a whole host of less well-known utilities available to us that really allow us to turn things up a notch. The best thing is, they’re so unknown that your competitors have probably never heard of them either! In this workshop, we’ll take a deep dive into some of the more esoteric and obscure tools to give you a real advantage over the competition.",
                "Harry Roberts");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Java SE 9, and its hidden treasures walkthrough",
                "Java SE 9 is a major release for the Java programming language and the Java virtual machine. It includes many changes. Some have gotten more coverage than others, but I'm going to talk about both the major changes and a few of the minor ones. Probably the most attention has gone to REPL and Project Jigsaw, a set of new modularity capabilities that let you package the code and interact with it as modules. This includes module System, visibility, linking and a few other capabilities. So, let’s take a tour of the new features in Java SE 9, powered by code, the platform designed to support faster, easier, and modular Java development.",
                "Mohamed Taman");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                ".NET Data Security: Hope is not a Strategy",
                "Not encrypting your data is a risky move and just relying on the \u200Bhope that you won't get hacked and compromised is not a strategy. As a software developer you have a duty to your employer to secure and protect their data. In this talk, you will learn how to use the .NET Framework to protect your data to satisfy confidentiality, integrity, non-repudiation, and authentication. This talk covers random number generation, hashing, authenticated hashing, and password based key derivation functions. The talk also covers both symmetric and asymmetric encryption using DES, Triple DES, AES, and RSA. You then learn how to combine these all together to produce a hybrid encryption scheme which includes AES, RSA, HMACS, and Digital Signatures.",
                "Stephen Haunts");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Microservices epiphany",
                "Microservices are still all over the place and people continue to experience various great realizations on the way to Microservices architecture. In this talk we will discuss what Microservices are and I will give some hints when you shouldn't do and when you should do Micrtoservices. Sometimes you even have no choice, but go Distributed. In any case if Microservices is the way to go you have to be prepared. We will discuss a few characteristics of distributed systems that I find sexy and mostly helpful to manage the complexity. We will talk about REST, Streams and Sockets, Reactive Programming, Reactive Systems, Event-Driven Architecture, Serverless Architecture, The Web, ACID, SOLID, Fault Tolerance, Backpressure even OOP, DDD and the Actor Model. We will mention Akka, Spring, Servlets, Tomcat and Netty, NodeJS and Vert.x, Kafka, Cassandra, Firebase and even Wordpress.",
                "Kalin Maldzhanski");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Build serverless applications with ease",
                "Serverless is the new black - I can deploy my application to the cloud without ever worrying about infrastructure. We all remember the days when we had to spend hours and hours configuring and debugging web servers when all we wanted was to just code and test our app. Those days are long gone and it’s time for us to unlearn how to provision and manage infrastructure while focusing on building and scaling applications.",
                "Simona Cotin");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "JUnit 5 - the next generation of JUnit",
                "New version of the JUnit library changes a lot - starting from the modules structure and ending on the way how you write your tests. JUnit 5 adds powerful and useful features and many improvements over the previous version. And on top of that we finally get the Java 8 syntax. During the presentation we will explore new features of JUnit. We will find out what is new and what was changed in current library version. We will compare the way how we wrote tests with JUnit 4 and how we can do it with JUnit 5.",
                "Sebastian Malaca");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Java 9 Is Here!",
                "Java 9 is out and it is more than just the module system (yes, I was surprised, too). In this talk you'll learn about nifty new language features, new APIs like stack walking and collection factory methods, the additions to existing APIs, like `Stream`, `Optional`, the Process API, and other niceties like multi-release JARs and performance improvements. The elephant in the room, Jigsaw, will also get its five minutes in the spotlight. After this talk you will be prepared to finally get started with Java 9's new features.",
                "Nicolai Parlog");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "IoT at Scale: Personal and Industrial",
                "In their research note that published in 2013, Gartner introduced the term “web-scale IT”. Current notions of “Web scale” will be dwarfed by “IoT scale” requirements in industry and personal automation, analytics, data management, and at every layer of the stack. We’re going to bridge high scale architectures and infrastructures with the kind of business issues that face SAP customers every day. This Industry 4.0 revolution and its scale bring new requirements for technology and skills, that we are going to discuss too. And – as you will see! – it is not much different, and yet still fun, to do IoT on a personal scale too.",
                "Vitaliy Rudnytskiy");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "How to validate architecture & design principles in code at compile time for .NET Projects",
                "A lot of work should be done before actual development could start. Conceptual models, different views on system – everything should be aligned with business requirement, but how to get confidence that implementation reflects architectural and design intentions? Code review is good approach, but it is time consuming, maybe something can be automatized? In my presentation I’m going to show you what can you do to save some time and not reinvent the wheel from the very beginning. And it’s not about simple code forms, that can be checked by StyleCop.",
                "Andrei Gordienkov");

        mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "Refactoring monolithic component containers to sub-containers",
                "The bigger a monolithic application, the larger the dependency set. Adding or changing dependencies becomes a tricky task. Similarly, the complexity is in the number of beans and their dependencies in components container. You learn how to split a monolithic SpringFramework ApplicationContext into a set of sub-contexts, how to isolate sub-context internal components, clear their APIs and avoid non-trivial dependencies. Each sub-context can have its own classpath, which tackles the dependency hell problem. After being divided, a monolithic system becomes easier to split into a set of micro-services or processes. From the talk, attendees will learn several practical tips and tricks on how to split component containers into smaller ones to reduce the complexity.",
                "Eugene Petrenko");

      /*  mDbAdapter.createEvent("2017-12-13", "B-2 aud. 100",
                "",
                "",
                "");

*/

    }

}

