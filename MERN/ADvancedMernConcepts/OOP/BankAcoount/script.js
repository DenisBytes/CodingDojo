class User {
    constructor(name, email) {
        this.name = name;
        this.email = email;
        this.accounts = {}; // Object to hold multiple accounts
    }

    createAccount(accountName, intRate = 0.05, balance = 0) {
        this.accounts[accountName] = new BankAccount(intRate, balance);
        return this;
    }

    makeWithdrawl(accountName, amount) {
        if (this.accounts[accountName]) {
            this.accounts[accountName].withdraw(amount);
        } else {
            console.log("Account not found");
        }
        return this;
    }

    makeDeposit(accountName, amount) {
        if (this.accounts[accountName]) {
            this.accounts[accountName].deposit(amount);
        } else {
            console.log("Account not found");
        }
        return this;
    }

    displayBalance(accountName) {
        if (this.accounts[accountName]) {
            console.log(`Your balance for ${accountName} is: `, this.accounts[accountName].balance);
        } else {
            console.log("Account not found");
        }
        return this;
    }

    transferMoney(fromAccount, toUser, toAccount, amount) {
        if (this.accounts[fromAccount] && toUser.accounts[toAccount]) {
            this.makeWithdrawl(fromAccount, amount);
            toUser.makeDeposit(toAccount, amount);
        } else {
            console.log("Account not found");
        }
        return this;
    }
}

class BankAccount {
    constructor(intRate = 0.05, balance = 0) {
        this.intRate = intRate;
        this.balance = balance;
    }

    deposit(amount) {
        this.balance += amount;
        return this;
    }

    withdraw(amount) {
        if (this.balance < amount) {
            console.log("Insufficient funds: Charging a $5 fee");
            this.balance -= 5;
        } else {
            this.balance -= amount;
        }
        return this;
    }

    displayAccountInfo() {
        console.log("Your balance is: ", this.balance);
        return this;
    }

    yieldInterest() {
        if (this.balance > 0) {
            this.balance += this.balance * this.intRate;
        } else {
            console.log("NO FUNDS LEFT");
        }
        return this;
    }
}

const user1 = new User("Denis", "a@gmail.com");
const user2 = new User("Egli", "b@gmail.com");

user1.createAccount("primary", 0.03, 1000); // Creating multiple accounts
user2.createAccount("savings", 0.04, 500);

user1.makeDeposit("primary", 100);
user2.makeDeposit("savings", 200);

user1.displayBalance("primary");
user2.displayBalance("savings");

user1.transferMoney("primary", user2, "savings", 50);

user1.displayBalance("primary");
user2.displayBalance("savings");
