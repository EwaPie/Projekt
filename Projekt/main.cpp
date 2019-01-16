//#include <QGuiApplication>
//#include <QQmlApplicationEngine>
//#include <QQuickStyle>
//#include "SFML/Graphics.hpp"
#include <iostream>
#include "../application/ContextManager/ContextManager.h"
#include "../application/Report/Bill.h"
#include "../application/Report/BillType.h"
#include "../application/Report/ReportType.h"
#include "../application/MenuItem/MenuItem.h"


int main(int argc, char *argv[]) {
//   QCoreApplication::setAttribute(Qt::AA_EnableHighDpiScaling);
//
//   QQuickStyle::setStyle("Material");
//
//    QGuiApplication app(argc, argv);
//
//    QQmlApplicationEngine engine;
//    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));
//    if (engine.rootObjects().isEmpty())
//        return -1;
//
//    return app.exec();

    shared_ptr<ContextManager> contextManager = ContextManager::getInstance();

    shared_ptr<Bill> rachunek;

    auto menuItem = make_shared<MenuItem>("Obiad", 10.0, 12.3, 0.23, 100);

    rachunek->addMenuItem(menuItem);
    rachunek->setBillType(make_shared<BillType>(BillType::BILL));

    rachunek->payYour();
    rachunek->closeBill();

    auto now = std::chrono::system_clock::now().time_since_epoch();
    auto t10000ms = std::chrono::milliseconds(10000);
    auto from = now - t10000ms;
    auto to = now + t10000ms;


    string report = contextManager->getReportService()->createFinancialReport(ReportType::INCOME, from.count(),
                                                                              to.count());

    cout << report;

}
