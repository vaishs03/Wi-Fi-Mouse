package com.sid.wi_fi_mouse;

import java.io.PrintWriter;
import java.net.Socket;

/*
  Created by Siddharth Sonawane on 14-April-2021.
  Siddharth Sonawane
 K.B.H. Polytechnic Malegaon,
 Nashik-423 205, India
 */

/*Copyright Siddharth Sonawane
 *Copyright infringement is the use of works protected by copyright law
 * without permission, infringing certain exclusive rights granted to the copyright holder,
 * such as the right to reproduce, distribute, display or perform the protected work, or to make derivative works.
 * It is a punishable offence under Copyright Act, 1957
 */


public class ConnectionSingleton {

    private static PrintWriter pwt;
    private static Socket socket;

    public static void setPrintWriter(PrintWriter _pwt) {
        ConnectionSingleton.pwt = _pwt;
    }

    public static PrintWriter getPrintWriter() {
        return ConnectionSingleton.pwt;
    }

    public static void setSocket(Socket _socket) {
        ConnectionSingleton.socket = _socket;
    }

    public static Socket getSocket() {
        return ConnectionSingleton.socket;
    }
}
/*
  Created by Siddharth Sonawane on 14-April-2021.
  Siddharth Sonawane
 K.B.H. Polytechnic Malegaon,
 Nashik-423 205, India
 */