package de.leetgeeks;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * JOculus
 * User: Sebastian Greif
 * Date: 12.04.2015
 * Time: 08:13
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");
        GLCanvas canvas = initGL();

        canvas.addGLEventListener(new GLEventListener() {
            @Override
            public void init(GLAutoDrawable glAutoDrawable) {
                GL4 gl = glAutoDrawable.getGL().getGL4();
                StringBuilder out = new StringBuilder();
                JoglVersion.getGLInfo(gl, out);
                System.out.println(out.toString());
            }

            @Override
            public void dispose(GLAutoDrawable glAutoDrawable) {

            }

            @Override
            public void display(GLAutoDrawable glAutoDrawable) {
                GL4 gl = glAutoDrawable.getGL().getGL4();
                gl.glClearColor(1, 0, 0, 0);
                gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            }

            @Override
            public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int w, int h) {
                GL3 gl3 = glAutoDrawable.getGL().getGL3();
                gl3.glViewport(x, y, w, h);
            }
        });



        JFrame frame = new JFrame("");
        frame.add(canvas);
        frame.setSize(canvas.getWidth(), canvas.getHeight());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }


    private static GLCanvas initGL() {
        GLProfile profile = GLProfile.get(GLProfile.GL4);
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDoubleBuffered(true);
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.setSize(1920, 1080);
        return canvas;
    }
}
