@GestionAlert
Feature: Gestion des alertes

	Scenario: afficher une alerte simple et la fermer avec ok
		Given je suis dans la page demoQA
		When je clique sur le bouton Click Button to see alert
		Then une alerte s'affiche
		When je clique sur OK de l'alerte
		Then l'alerte disparait