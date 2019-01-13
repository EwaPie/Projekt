import QtQuick 2.9
import QtQuick.Controls 2.2
import QtQuick.Layouts 1.3

ApplicationWindow {

    id: window
    visible: true
    width: 800
    height: 680
    title: qsTr("Aplikacja")

    StackView {
        id: stackview
        initialItem: login_page

    }

    Component {
        id: login_page
        LoginForm {
            login_button.onClicked: {
                stackview.push(starting_page)
         }
        }
    }

    Component {
        id: starting_page
        StartingPageForm {
            menu_button.onClicked: {
                stackview.push(menu_page)
            }
            hall_button.onClicked: {
                stackview.push(hall_page)
            }
            statisticks_button.onClicked: {
                stackview.push(statistics_page)
            }
            users_button.onClicked: {
                stackview.push(users_page)
            }
            discounts_button.onClicked: {
                stackview.push(discounts_page)
            }
        }
    }

    Component {
        id: users_page
        UsersForm {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: statistics_page
        StatisticsForm {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: discounts_page
        DiscountsForm {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: hall_page
        HallForm {
            table1.onClicked: {
                stackview.push(order_1)
            }

            table2.onClicked: {
                stackview.push(order_2)
            }

            table3.onClicked: {
                stackview.push(order_3)
            }

            table4.onClicked: {
                stackview.push(order_4)
            }

            table5.onClicked: {
                stackview.push(order_5)
            }

            toolButton.onClicked: {
                stackview.push(starting_page)
            }


        }
    }

    Component {
        id: menu_page
        MenuForm {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }

        }
    }

    Component {
        id: order_1
        OrderForm1 {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: order_2
        OrderForm2 {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: order_3
        OrderForm3 {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: order_4
        OrderForm4 {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

    Component {
        id: order_5
        OrderForm5 {
            toolButton.onClicked: {
                stackview.push(starting_page)
            }
        }
    }

}
