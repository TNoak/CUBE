#include <DHT.h>

String error = "n";

String start = "a";
String finish = "b";
String t = "t";
String h = "h";
String num = "n";

String message;

const int sensorcount = 15;

DHT *myDHT[sensorcount];



void setup() {
  Serial.begin(9600);


  for (int n = 0; n < sensorcount ; n++)
  {
    myDHT[n] = new DHT(n + 2 , 22); // define a sensor at pin 'n' with sensor type DHT22
  }

}

void loop() {

  delay(3000);
  for (int n = 0; n < sensorcount; n++)
  {
    message = "";

    message += start; //message start

    message += num;
    message += n;
    message += num;

    float temp = myDHT[n]->readTemperature();
    float humi = myDHT[n]->readHumidity();

    message += t;
    if (!isnan(temp)) {
      message += temp;
    } else {
      message += "error";
    }
    message += t;

    message += h;
    if (!isnan(humi)) {
      message += humi;
    } else {
      message += "error";
    }
    message += h;

    message += finish;//message finish

    Serial.println(message);
  }

  Serial.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

}

