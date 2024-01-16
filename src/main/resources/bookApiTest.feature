Feature: Mock Book API

  Background:
    * url 'http://localhost:8080/api'

  Scenario: pathMatches('/books/1')
    Given path '/books/1'
    When method get
    Then status 200
    And def response = { id: 1, title: 'Some Book Title', author: 'Author Name' }
    And def responseHeaders = { 'Content-Type': 'application/json' }


  Scenario: pathMatches('/books') && methodIs('post')
    * def requestJson = read('request');
    * match requestJson contains { title: '#string', author: '#string' }

    When method post
    Then status 201
    And def response = { id: (books.size() + 1), title: requestJson.title, author: requestJson.author }
    And def responseHeaders = { 'Content-Type': 'application/json' }

    * def functionVar = function(){books.add(response)}
    * call functionVar

    * print 'New book added: ', response