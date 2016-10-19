// File   : GUI-lowlevel/cards1/cards/Card.java
// Purpose: Represents one card.
//
// Enhancements:
//          * Needs to have Suit and Face value.

package cards;

import java.awt.*;
import javax.swing.*;

/////////////////////////////////////////////////////////////////////////// Card
class Card {
    //=================================================================== fields
    private ImageIcon _image;
    private ImageIcon _backImage;
    private int       _x;
    private int       _y;
    private boolean flipped = false;
    
    //============================================================== constructor
    public Card(ImageIcon image) {
        _image = image;
	_backImage = new ImageIcon("cards/images/b.gif");//back of card
    }

    public boolean getFlip(){
	return flipped;
    }

    public void flip(){//for showing back of card
	flipped = !flipped;
    }
    
    //=================================================================== moveTo
    public void moveTo(int x, int y) {
        _x = x;
        _y = y;
    }
    
    //================================================================= contains
    public boolean contains(int x, int y) {
        return (x > _x && x < (_x + getWidth()) && 
                y > _y && y < (_y + getHeight()));
    }
    
    //================================================================= getWidth
    public int getWidth() {
        return _image.getIconWidth();
    }
    
    //================================================================ getHeight
    public int getHeight() {
        return _image.getIconHeight();
    }
    
    //===================================================================== getX
    public int getX() {
        return _x;
    }
    
    //===================================================================== getY
    public int getY() {
        return _y;
    }
    
    //===================================================================== draw
    public void draw(Graphics g, Component c) {
	if(!flipped)
	    _image.paintIcon(c, g, _x, _y);//tells paint whether to draw card or back of card
	else
	    _backImage.paintIcon(c, g, _x, _y);
    }
}
