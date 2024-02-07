# Générateur de Cartes Spring Boot

Cette application Spring Boot fournit une api pour générer des cartes pour un joueur et trier les cartes générées.

## Prérequis

Assurez-vous d'avoir Java et Maven installés sur votre machine.

## Installation et exécution

**Compilez et exécutez l'application à l'aide de Maven :**
    ```bash
    mvn spring-boot:run
    ```

L'application sera exécutée sur `http://localhost:8080`.

## Utilisation

### Génération de cartes

Pour générer des cartes pour un joueur, envoyez une requête GET à l'endpoint `/generate`. L'application générera 10 cartes pour le joueur et renverra le résultat au format JSON.

requête :

```bash
curl http://localhost:8080/generate
 ```

### Tri des cartes
Pour trier les cartes générées, envoyez une requête GET à l'endpoint /sort avec le json recu précedemment par exemple. L'application triera les cartes selon l'ordre des symboles et des valeurs, puis renverra le résultat trié au format JSON.

Voici l'ordre de trie :

--> Carreaux, Coeur, Pique, Trèfle

--> As, 5, 10, 8, 6, 7, 4, 2, 3, 9, Dame, Roi, Valet


requête :
```bash
curl http://localhost:8080/sort
 ```

Ce projet a été développé en utilisant la méthode de développement piloté par les tests (TDD).
Ceci est une v1 et sera ameliorer bientot pour gérer toutes les exceptions.
