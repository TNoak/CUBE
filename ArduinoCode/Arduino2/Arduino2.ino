#include <Servo.h>

Servo myservo1, myservo2, myservo3, myservo4;

String message;
int value;

String string;
int messagelength;
boolean newdata = false;

void setup() {
  // put your setup code here, to run once:
  myservo1.attach(3);
  myservo1.write(0);
  myservo2.attach(4);
  myservo2.write(0);
  myservo3.attach(5);
  myservo3.write(0);
  myservo4.attach(6);
  myservo4.write(0);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  readMessage();
  controlServo();

}

void controlServo() {
  if (message.length() == 4) {
    long val = message.toInt();
    value = val;
    message = "";
    if (value >= 1000 && value <= 1180) {
      myservo1.write(value-1000);
    } else if (value >= 2000 && value <= 2180) {
      myservo2.write(value-2000);
    } else if (value >= 3000 && value <= 3180) {
      myservo3.write(value-3000);
    } else if (value >= 4000 && value <= 4180) {
      myservo4.write(value-4000);
    } else {
      value = 0;
    }
  }
}

void readMessage() {
  if (Serial.available() > 0) {
    char character = Serial.read();

    if (character == '>') {
      newdata = false;
      message = string;
      Serial.println(message);
      string = "";
    }

    if (newdata) {
      string += character;
    }

    if (character == '<') {
      newdata = true;
    }

  }
}

