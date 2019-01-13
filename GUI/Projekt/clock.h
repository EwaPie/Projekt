#ifndef CLOCK_H
#define CLOCK_H
#include <QDebug>
#include <QObject>
#include <QTime>
#include <QTimer>

class Clock : public QObject
{
    Q_OBJECT

public:
    Clock();
    int sekundy = 10;
    QTimer *timer = new QTimer();

public slots:
    void tick();
};

#endif // CLOCK_H
