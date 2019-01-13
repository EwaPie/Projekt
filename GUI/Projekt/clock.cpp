#include "clock.h"

Clock::Clock()
{


}

void Clock::tick(){
 qDebug() << sekundy;
 sekundy--;

 if (sekundy <= -1){
     timer->stop();
     delete timer;
 }
}
