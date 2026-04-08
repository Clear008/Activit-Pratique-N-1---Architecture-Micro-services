<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>
<body>

  <h1> TP Microservices</h1>

<h2>Objectif</h2>
  <p>
    L’objectif de ce TP est de réaliser une application basée sur une
    <strong>architecture microservices</strong> permettant de gérer :
  </p>
  <ul>
    <li>les <strong>clients</strong></li>
    <li>les <strong>produits</strong></li>
    <li>les <strong>factures</strong></li>
    <li>la communication entre services</li>
  </ul>
  <p>
    Chaque facture appartient à un client et contient une liste de produits.
  </p>

<h2>Architecture du projet</h2>

<h3>1. customer-service</h3>
  <p>Service responsable de la gestion des clients :</p>
  <ul>
    <li>ajout d’un client</li>
    <li>consultation des clients</li>
    <li>modification</li>
    <li>suppression</li>
  </ul>

<h3>2. inventory-service</h3>
  <p>Service responsable de la gestion des produits :</p>
  <ul>
    <li>ajout d’un produit</li>
    <li>consultation des produits</li>
    <li>gestion du prix, quantité, etc.</li>
  </ul>

<h3>3. billing-service</h3>
  <p>Service responsable de la facturation :</p>
  <ul>
    <li>création des factures</li>
    <li>association d’une facture à un client</li>
    <li>ajout des produits dans la facture</li>
    <li>récupération des informations client et produit via <strong>OpenFeign</strong></li>
  </ul>

<h3>4. gateway-service</h3>
  <p>Point d’entrée unique de l’application :</p>
  <ul>
    <li>routage des requêtes vers les bons microservices</li>
    <li>configuration statique puis dynamique des routes</li>
  </ul>

<h3>5. discovery-service</h3>
  <p>Service d’enregistrement et de découverte basé sur <strong>Eureka</strong> :</p>
  <ul>
    <li>permet aux microservices de se localiser automatiquement</li>
  </ul>

<h3>6. config-service</h3>
  <p>Service de configuration centralisée :</p>
  <ul>
    <li>externalisation des fichiers de configuration</li>
    <li>centralisation de la configuration des microservices</li>
  </ul>

<h3>7. angular-client</h3>
  <p>Interface utilisateur développée avec <strong>Angular</strong> :</p>
  <ul>
    <li>permet d’interagir avec les microservices depuis une application web</li>
  </ul>

<h2>Travail demandé</h2>
  <ol>
    <li>Créer le microservice <strong>customer-service</strong></li>
    <li>Créer le microservice <strong>inventory-service</strong></li>
    <li>Créer la <strong>Spring Cloud Gateway</strong></li>
    <li>Mettre en place une <strong>configuration statique</strong> du routage</li>
    <li>Créer le serveur <strong>Eureka Discovery Service</strong></li>
    <li>Mettre en place une <strong>configuration dynamique</strong> des routes de la gateway</li>
    <li>Créer le <strong>billing-service</strong> en utilisant <strong>OpenFeign</strong></li>
    <li>Créer le <strong>config-service</strong></li>
    <li>Créer un <strong>client Angular</strong></li>
  </ol>

<h2>Technologies utilisées</h2>
  <ul>
    <li>Java</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>Spring Cloud Gateway</li>
    <li>Spring Cloud Eureka</li>
    <li>OpenFeign</li>
    <li>Spring Cloud Config</li>
    <li>H2 / MySQL</li>
    <li>Angular</li>
    <li>Maven</li>
  </ul>

<h2>Fonctionnement général</h2>
  <ul>
    <li>Le <strong>customer-service</strong> gère les données des clients.</li>
    <li>Le <strong>inventory-service</strong> gère les données des produits.</li>
    <li>Le <strong>billing-service</strong> crée les factures et récupère les informations du client et des produits à distance.</li>
    <li>La <strong>gateway</strong> sert de point d’accès central.</li>
    <li><strong>Eureka</strong> permet aux services de s’enregistrer et de se découvrir.</li>
    <li>Le <strong>config-service</strong> permet de centraliser les configurations.</li>
    <li>Le client <strong>Angular</strong> consomme les APIs exposées par la gateway.</li>
  </ul>



</body>
</html>