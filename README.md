# Task-Helper
Inspired by the Quest Helper RuneLite plugin, this plugin will guide you step by step through recurring tasks.

*This is the first time I've created a RuneLite plugin so for now I will place my notes for learning about this project here.*


# Resources
  - [RuneLite Wiki](https://github.com/runelite/runelite/wiki  )
    - Scroll down the right panel for development documentation 
  - [RuneLite Plugin Hub Documentation](https://github.com/runelite/plugin-hub/blob/master/README.md)
  - [Creating Plugin Config Panel](https://github.com/runelite/runelite/wiki/Creating-plugin-config-panels)
  - [Creating Development Logging](https://github.com/runelite/runelite/wiki/Plugin-Development-Logging)  
  - [YouTube Video: "How to create a RuneLite plugin" by MakingStan](https://www.youtube.com/watch?v=mB5Wxfx0Ork&ab_channel=MakingStan)
  - ["Creator's Kit Tutorial | A RuneLite Plugin for Creating Custom Scenes" by ScretMonge](https://www.youtube.com/watch?v=LRUrMMfdy60&ab_channel=ScreteMonge)
  - [RuneLite Development Discord](https://discord.gg/runelite)  

**Main RuneLite Links:**
  - [Building](https://github.com/runelite/runelite/wiki/Building-with-IntelliJ-IDEA)
  - [Plugin Configs](https://github.com/runelite/runelite/wiki/Creating-plugin-config-panels)
  - [Coding Conventions](https://github.com/runelite/runelite/wiki/Code-Conventions)


# Setup the Development Environment
Following [this YouTube video](https://www.youtube.com/watch?v=mB5Wxfx0Ork&ab_channel=MakingStan) I learned:  

  - [Download IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows)
    - ~~Needs an account and to pay a license?~~ 
    - Free as a student email address.

  - Download Java 11 JDK for Windows x64 .msi via IntelliJ
    - [Latest Java JDK download](https://adoptium.net/temurin/releases/) (don't use this link)
    - Should I get the latest Java JDK or version 11?
    > To create RuneLite plugins, you can build RuneLite locally using JDK 11. It is recommended to install the JDK through IntelliJ and select the vendor Eclipse Temurin (AdoptOpenJDK HotSpot) version 11. The codebase supports language features up to Java 11. [per RunLite "Building with IntelliJ IDEA"](https://github.com/runelite/runelite/wiki/Building-with-IntelliJ-IDEA)
    - ~~Should I get x86 architecture?~~ Just install it through IntelliJ per the RuneLite wiki and the YouTube guide.

  - Make a Git repository for the plugin
  - Clone the repository to IntelliJ
  - MakingStan video wanted me to clone his repo, but I made my own... He then creates a "configuration" using his premade files from the repo. I'll have to figure this out later.

# Following the [RuneLite Wiki](ttps://github.com/runelite/plugin-hub/blob/master/README.md#creating-new-plugins)
  - [x] Added files from [example repository](https://github.com/runelite/example-plugin)
    - Do I need these? I dislike having code/files that I don't understand how they work.
  - [ ] 