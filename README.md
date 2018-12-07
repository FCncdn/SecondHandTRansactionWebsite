# SecondHandTRansactionWebsite
jsp+servlet+mysql+javaBean

- Collaborators

    tunlezaH

- MySQL 设置

    driverClassName = com.mysql.jdbc.Driver

    url = jdbc:mysql://localhost:3306/System?serverTimezone=GMT%2B8&characterEncoding=utf8

    username = root

    password = fcncdn

- MYSQL 表

1. dialogue

    | iddialogue | playerA | playerB | activiteItemId |
    |------------|---------|---------|----------------|


2. items

    | item_id | item_name | item_price | serller_id | item_count | item_status | type |
    |---------|-----------|------------|------------|------------|-------------|------|

3. message

    | idmessage | sender | receiver | isread | time | content | type | dialogueId |
    |-----------|--------|----------|--------|------|---------|------|------------|

4. orders

    | idorders | seller | buyer | itemId | phone | address |
    |----------|--------|-------|--------|-------|---------|

5. user

    | iduser | username | password | email | sex |
    |--------|----------|----------|-------|-----|
