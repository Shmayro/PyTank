print "Bonjour, je suis un script python, on m'a donner la telecommande d'un tank, je suis content ^^, mais comme je sais pas m'en servir, je vais tourner en rond."

tank.moveForward()
while True:
	tank.moveForward()
	
	if tank.distanceOfForwardObstacle() > 0 and tank.distanceOfForwardObstacle() < 2:
		tank.turnClockwise()
	
	
