const express = require('express');
const app = express();
const port = 8000;

const { faker } = require('@faker-js/faker');

const createUser = () => {
    const newUser = {
        passord: faker.internet.password(),
        email: faker.internet.email(),
        firstName: faker.person.firstName(),
        lastName: faker.person.lastName(),
        phoneNumber: faker.phone.number(),
        id: faker.string.uuid(),
    }
    return newUser;
}

const createCompany = () => {
    const newCompany = {
        name: faker.company.name(),
        id: faker.string.uuid(),
        address: {
            street: faker.location.street(),
            city: faker.location.city(),
            state: faker.location.state(),
            zipCode: faker.location.zipCode(),
            country: faker.location.country(),
        }
    }
    return newCompany;
}

app.get('/api/users/new', (req, res) => {
    res.json(createUser());
});

app.get('/api/companies/new', (req, res) => {
    res.json(createCompany());
})

app.get('/api/companies/users', (req, res) => {
    res.json([createUser(), createCompany()]);
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`);
})
