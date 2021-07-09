package model;

import com.github.javafaker.Faker;

import java.util.Random;

public abstract class UserUtility implements Customer, Role {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static UserModel generateUserModel() {
        return new UserModel()
                .builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .userName(faker.name().username())
                .password(faker.internet().password())
                .customer(companies.get(random.nextInt(2)))
                .role(roles.get(random.nextInt(2)))
                .email(faker.internet().emailAddress())
                .cellPhone(faker.phoneNumber().cellPhone())
                .build();
    }

}
