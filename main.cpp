#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QQuickStyle>

#include "clock.h"
#include <QTimer>

Clock *clock_ = new Clock(); // obiekt klasy QClock

void clock_function()
{
    clock_->timer->setInterval(1000); // ustawiam interwał czasowy na 1000 milisekund

    QObject::connect(clock_->timer, SIGNAL(timeout()), clock_, SLOT(tick())); // podpinam pod sygnał timeout obiketu timer podpinam slot tick z obiektu QClock

    clock_->timer->start(); // uruchamiam zegar
}


int main(int argc, char *argv[])
{
   QCoreApplication::setAttribute(Qt::AA_EnableHighDpiScaling);

   QQuickStyle::setStyle("Material");

    QGuiApplication app(argc, argv);

    QQmlApplicationEngine engine;
    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));
    if (engine.rootObjects().isEmpty())
        return -1;


    clock_function();

    return app.exec();

}
