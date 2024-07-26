# Hello-Events


## Contexte du Projet

En tant que développeur junior, vous devez concevoir et développer une application Web pour la réservation de billets pour des événements, conformément aux exigences du client.


## Exigences du Projet

### Pour les Clients

**Données de la Page d'Accueil :**
- Récupérer les informations sur les événements à afficher sur la page d'accueil.

**Inscription et Connexion :**
- Gérer l'inscription des nouveaux utilisateurs (création de compte).
- Gérer la connexion des utilisateurs existants (authentification).
- Récupérer et mettre à jour les informations de profil utilisateur.

**Recherche et Filtrage des Événements :**
- Effectuer des recherches d'événements en fonction de divers critères (date, lieu, catégorie, etc.).

**Réservation d'Événement :**
- Effectuer l'achat d'un billet.

**Information sur l'Équipe et les Valeurs :**
- Récupérer les informations sur l'équipe et les valeurs à afficher sur la page "À Propos".

**Gestion des Contacts :**
- Recevoir et stocker les demandes de contact envoyées via un formulaire de contact.

### Pour les Administrateurs

**Tableau de Bord :**
- Récupérer les données sur les activités des clients et les événements (inscriptions, achats, etc.).

**Gestion des Comptes et des Événements :**
- Gérer les comptes clients (affichage, suppression).
- Gérer les événements (création, mise à jour, suppression, consultation des détails).

**Traitement des Demandes de Contact :**
- Recevoir, consulter et répondre aux demandes de contact envoyées via le formulaire.

### Dockerisation de l'Application

- Créer un fichier `Dockerfile` pour containeriser l'application Spring Boot.
- Tester votre application (docker container) après le déploiement.
## Documentation

La documentation de l'API est disponible à l'adresse suivante : [Swagger UI](http://localhost:8080/swagger-ui/index.html#)

## Tests des API

Les tests des API sont effectués avec [Postman](https://www.postman.com/) et sont inclus dans le projet. Voici les étapes pour tester les API :

1. **Importation de la Collection Postman :**
   - Téléchargez le fichier de collection Postman depuis le répertoire `postman/`.
   - Importez-le dans Postman via `File` > `Import`.

2. **Exécution des Tests :**
   - Ouvrez la collection importée dans Postman.
   - Exécutez les requêtes pour tester les différents points de terminaison de l'API.
   - Vérifiez les réponses pour vous assurer que l'API fonctionne comme prévu.

3. **Vérification des Résultats :**
   - Analysez les résultats des tests pour vérifier la conformité avec les spécifications.
   - Corrigez les éventuelles erreurs ou incohérences trouvées.
     
## Tests Unitaires

Les tests unitaires sont écrits en utilisant [JUnit](https://junit.org/junit4/) pour assurer la qualité et le bon fonctionnement des composants individuels de l'application. Voici comment exécuter les tests unitaires :

1. **Configuration des Tests :**
   - Assurez-vous que votre environnement de développement est configuré pour exécuter les tests JUnit. Vous pouvez utiliser un IDE comme IntelliJ IDEA ou Eclipse, ou bien exécuter les tests via la ligne de commande.

2. **Exécution des Tests :**
   - Pour exécuter les tests depuis la ligne de commande, utilisez la commande suivante :
     ```bash
     mvn test
     ```
   - Pour exécuter les tests depuis un IDE, recherchez et exécutez les configurations de test JUnit.

3. **Analyse des Résultats :**
   - Examinez les rapports de test pour identifier les échecs et les erreurs.
   - Corrigez les bugs détectés par les tests unitaires et assurez-vous que les tests passent avant de finaliser les développements.


## Technologies

- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- JUnit
- MySQL/PostgreSQL
