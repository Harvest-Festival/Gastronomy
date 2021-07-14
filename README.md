<img src="https://harvestfestivalwiki.com/images/d/d9/Gastronomy_Logo.svg" width="50%">

[![Discord](https://img.shields.io/discord/227497118498029569?style=plastic&colorB=7289DA&logo=discord&logoColor=white)](http://discord.gg/0vVjLvWg5kyQwnHG) &nbsp; ![GitHub](https://img.shields.io/github/license/Harvest-Festival/Gastronomy?color=%23990000&style=plastic)

Gastronomy is the cooking element of the Harvest Festival Collection. It adds a kitchen set, recipes and herbs in order to cook to your desires. As well as a bunch of new foods.

Adding Gastronomy to your buildscript
---
Add to your build.gradle:
```gradle
repositories {
  maven {
    url 'https://maven.joshiejack.uk/'
  }
}

dependencies {
    compile fg.deobf("uk.joshiejack.penguinlib:Penguin-Lib:${minecraft_version}-${penguinlib_version}")
    compile fg.deobf("uk.joshiejack.gastronomy:Gastronomy:${minecraft_version}-${gastronomy_version}")
}
```

`${$penguinlib_version}` can be found [here](https://maven.joshiejack.uk/uk/joshiejack/penguinlib/Penguin-Lib/)
`${gastronomy_version}` can be found [here](https://maven.joshiejack.uk/uk/joshiejack/penguinlib/Gastronomy/)