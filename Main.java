import java.awt.Color;

class Main {
  public static void main(String[] args){
    Timer.start();
    EmojiLookupTable.buildLookupTable();
    System.out.println("Built emoji lookup table in " + Long.toString(Timer.stop()) + "ms");

    ImageUtils imgUtils = new ImageUtils();
    Color[][] defaultImageSrc = imgUtils.loadImage("./assets/LennaCV.png");

    imgUtils.addImage(ImageUtils.cloneArray(defaultImageSrc), "Default");

    Timer.start();
    Color[][] mosaicImage = Emojify.mosaicTest( 5, ImageUtils.cloneArray(defaultImageSrc) );
    imgUtils.addImage(mosaicImage, "Mosaic Test");
    System.out.println("Processed Mosaic Test in " + Long.toString(Timer.stop()) + "ms");

    Timer.start();
    Color[][] emojiImage = Emojify.emojify( 5, ImageUtils.cloneArray(defaultImageSrc) );
    imgUtils.addImage(emojiImage, "Emoji Image");
    System.out.println("Processed Emoji Test in " + Long.toString(Timer.stop()) + "ms");

    Timer.start();
    Color[][] lowResEmojiImage = Emojify.emojify( 10, ImageUtils.cloneArray(defaultImageSrc) );
    imgUtils.addImage(lowResEmojiImage, "Low Res Emoji Image");
    System.out.println("Processed Low Res Emoji Test in " + Long.toString(Timer.stop()) + "ms");

    Timer.start();
    Color[][] thonkImage = Emojify.emojify( 5, imgUtils.loadImage("./assets/Thonk.png") );
    imgUtils.addImage(thonkImage, "Thonk");
    System.out.println("Processed Thonk in " + Long.toString(Timer.stop()) + "ms");

    Timer.start();
    Color[][] laughingImage = Emojify.emojify( 5, imgUtils.loadImage("./assets/Laughing.png") );
    imgUtils.addImage(laughingImage, "Deaf Mutes");
    System.out.println("Processed Deaf Mutes in " + Long.toString(Timer.stop()) + "ms");

    Timer.start();
    Color[][] videoTest = Emojify.emojify( 8, imgUtils.loadImage("./assets/cat-with-sunglasses.jpg") );
    imgUtils.addImage(videoTest, "Cool Cat");
    System.out.println("Processed Cool Cat in " + Long.toString(Timer.stop()) + "ms");

    Timer.start();
    Color[][] birbImage = Emojify.emojify( 8, imgUtils.loadImage("./assets/birb.jpg") );
    imgUtils.addImage(birbImage, "Mom's Spaghetti");
    System.out.println("Served up Mom's Spaghetti in " + Long.toString(Timer.stop()) + "ms");


    imgUtils.display();

  }
}
