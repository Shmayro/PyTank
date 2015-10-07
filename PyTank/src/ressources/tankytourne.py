print "Bonjour, je suis un script python, on m'a donner la telecommande d'un tank, je suis content ^^, mais comme je sais pas m'en servir, je vais tourner en rond."

tank.moveForward();
tank.shoot();
while True:
	tank.moveForward();
	tank.moveForward();
	tank.moveForward();
	tank.moveForward();
	tank.shoot();
	tank.turnClockwise();
	
