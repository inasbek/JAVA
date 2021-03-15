# Projet - Competition

## Auteurs

- Bairouk Fatima-Zahra
- Bekkouche inas

## Objectifs atteints

### Premiere étape

* Il fallait lancer la commande tout en se plaçant dans le dossier de dépôt local:

 ```bash
 git pull origin master
 ```
 Pour récuperer le projet de GitLab et le mettre dans le dépot local.

* Ici le chemin pour le depot local serait :
 ```bash
 ~/eclipse-workspace/coo-projet/comp$
 ```
 Sur notre poste

### Objectif 1

* The objective of this project is to program an application of sports competitions which contains three types (championship and tournament and master) and at the end to return the winner.


### Objectif 2

Il fallait commencer par les tests pour avoir une idée sur les methodes qu'on devrai écrire, et ensuite commencer à écrire le code des methodes dans les differentes classes.
Ce qui etait facile et en écrivant le code en lance le RUN pour les tests pour savoir si notre code fonctionne.
Au final on a écrit la classe CompetitionMain qui va s'occuper de la competition
Nous avons réussi à faire ceci.
Sans oublie que l'étape la plus importante c'est la création des diagrammes UML.
* Ce qu'on a changé ou ajouté :
    - lors de la premiere version du projet , on avait besoin que de deux type de competitions(League & Tournament), mais dans cette version on a ajouté une competition(Master) qui fait jouer les players en premier dans une league , et on choisi (soit les premiers soit les derniers soit les meilleurs) et c'est grace à des strategies , pour jouer dans un Tournoi
    - lors de la troisieme version du projet , on ajoute les journalistes et les parieurs , qui eux commentent chaque match , et les bookmakers parient sur les joueurs ce qui modifient leurs cotes


## Comment générer la documentation ?

* Pour générer la documentation on doit exécuter la commande dans le dossier contenant le fichier (dont on veut la documentation)(fichier pére)
 ```bash
 javadoc -sourcepath src -d docs -subpackages competition util type match strategy observer
 ```
cette commande ci-dessus génère la documentation de tous les fichiers .java

## Comment compiler les classes du projet ?

Pour compiler les classes,
on lance la commande depuis le dossier pere
chemin : coo-projet/comp
- On a utilisé :
 ```bash
 javac -d ./classes -cp classpath src/match/*.java src/competition/*.java src/type/*.java src/util/*.java src/strategy/*.java src/observer/*.java

 ```

## Comment compiler puis exécuter les tests ?
On se déplace dans le répertoire TP5 dans le dépôt local
Chemin : coo-projet/comp
- On a utilisé :
    + Pour la compilation des tests:
   ```bash
  javac -classpath test-1.7.jar test/*.java
     ```
    + Pour l'exécution des tests :


   ```bash
    java -jar test-1.7.jar LeagueTest
   ```
 Pour executer tous les tests on utilise cette commande mais au lieu de LEAGUETest on met le nom de la classe  test qu'on veut tester



## Comment crééer le jar exécutable ?

Pour creer un jar il faut d'abord
- creer un manifest : en lançant la commande:
    ```bash
        cat > manifest
        Main-Class: competition.CompetitionMain
    ```


- apres on lance :
    ```bash
    jar cvfm appli.jar manifest -C classes competition -C classes util -C classes type -C classes match -C classes strategy -C classes observer
    ```




## Comment tester l'exécution du programme ?

 * Pour tester l'exécution du programme , on premiére etape , on devrait compiler tous les fichiers et lancer la commande :
 ```bash
 java ClasseMain
 ```
 qui va s'occuper d'executer le code qui est dans fichiersMain

- On a utilisé, par exemple :
 ```bash
 java -cp classes competition.CompetitionMain
 ```
 pour tester l'exécution du CompetitionMain .
