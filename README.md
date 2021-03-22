# Getting Started

## Dependencies

The first dependencies are:

- Java 11
- Spring Boot 2.4.4 as parent POM
- Starter Weblux + Reactor test


    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.projectreactor</groupId>
        <artifactId>reactor-test</artifactId>
        <scope>test</scope>
    </dependency>

## Goal

This project's goal is to start working with Reactor and Spring Webflux. 

### What to do

Update the code step by step following the instruction. Each step leaves in a different branch of this repo.

#### Plot

You are working in a garden center to sell Trees, Bamboos and other plants. This place is composed of 3 Greenhouses, one for each type of plants. Each `greenhouse` is divided into `rows` to let the customer brows your products. And to maintain the good health of your plants you have installed dripping system all over the place. Every `dropper` is _connected_ and sends a signal on every drip it releases.

We are going to analyse this information flow.

#### Step 1

Fill the `org.sixdouglas.formation.spring.irrigation.DripIrrigation.followDrops` function to make the associated Unit Test runs successfully.

#### Step 2

Then complete the `org.sixdouglas.formation.spring.irrigation.DripIrrigation.followDropper` and `org.sixdouglas.formation.spring.irrigation.producer.GreenHouseProducer.getDrops` functions to make the associated Unit Test runs successfully.

#### Step 3

Next complete the `org.sixdouglas.formation.spring.irrigation.DripIrrigation.followDetailedDropper`, `org.sixdouglas.formation.spring.irrigation.DripIrrigation.getDetailedDrop` functions to make the associated Unit Test runs successfully.
