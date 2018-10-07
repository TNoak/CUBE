#include <DHT.h>

int sensorcount = 2;
DHT *myDHT[2];

void setup() {
  Serial.begin(9600);

  for (int n = 0; n < sensorcount ; n++)
  {
    myDHT[n] = new DHT(n + 2, 22); // define a sensor at pin 'n' with sensor type DHT22
  }

}

void loop() {

  delay(3000);
  for (int n = 0; n < sensorcount; n++)
  {
    float h = myDHT[n]->readHumidity();
    float t = myDHT[n]->readTemperature();
    if (isnan(t)) {
      float error = -n;
      Serial.println(error);
    } else {
      if (n < 10) {
        Serial.print(0);
        Serial.print(n);
      } else {
        Serial.print(n);
      }

      Serial.println(t);
    }
    if (isnan(h)) {
      float error = -n;
      Serial.println(error);
    } else {
      if (n < 10) {
        Serial.print(0);
        Serial.print(n);
      } else {
        Serial.print(n);
      }

      Serial.println(h);
    }

  }
}

