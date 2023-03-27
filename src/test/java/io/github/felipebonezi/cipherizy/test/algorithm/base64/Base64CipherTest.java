package io.github.felipebonezi.cipherizy.test.algorithm.base64;

import static io.github.felipebonezi.cipherizy.algorithm.CipherFactory.Algorithm.BASE64;
import static java.nio.charset.StandardCharsets.UTF_8;

import io.github.felipebonezi.cipherizy.CipherException;
import io.github.felipebonezi.cipherizy.ICipher;
import io.github.felipebonezi.cipherizy.algorithm.CipherFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class Base64CipherTest {
  
  // region Large text.
  private static final String LARGE_TEXT =
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien et ligula. Iaculis eu non diam phasellus vestibulum lorem sed risus ultricies. Vitae aliquet nec ullamcorper sit amet risus nullam eget. Vulputate eu scelerisque felis imperdiet proin fermentum leo vel. Sed cras ornare arcu dui vivamus arcu felis bibendum. Nulla facilisi morbi tempus iaculis urna id. Lobortis elementum nibh tellus molestie nunc non blandit. Eu mi bibendum neque egestas. A condimentum vitae sapien pellentesque habitant.\n" +
          "\n" +
          "Posuere ac ut consequat semper viverra. Massa vitae tortor condimentum lacinia quis vel. Suspendisse sed nisi lacus sed viverra tellus in. Velit dignissim sodales ut eu sem integer vitae justo eget. Suspendisse faucibus interdum posuere lorem ipsum dolor sit amet consectetur. Integer malesuada nunc vel risus commodo viverra maecenas accumsan. Sit amet volutpat consequat mauris nunc congue nisi vitae. Dignissim suspendisse in est ante in nibh. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Vestibulum rhoncus est pellentesque elit ullamcorper. Egestas diam in arcu cursus euismod quis viverra nibh cras. Purus faucibus ornare suspendisse sed nisi lacus sed. Dui faucibus in ornare quam viverra. Laoreet id donec ultrices tincidunt arcu non sodales neque sodales. Et malesuada fames ac turpis.\n" +
          "\n" +
          "Lacinia at quis risus sed vulputate odio ut. Purus viverra accumsan in nisl nisi scelerisque eu ultrices vitae. In pellentesque massa placerat duis. Magna fermentum iaculis eu non diam phasellus. Ultrices dui sapien eget mi proin sed libero enim. Pellentesque id nibh tortor id aliquet lectus proin nibh nisl. Mattis aliquam faucibus purus in massa tempor. Amet consectetur adipiscing elit pellentesque habitant morbi tristique senectus. Pellentesque massa placerat duis ultricies lacus sed turpis. Sagittis vitae et leo duis ut diam quam nulla porttitor. Quam pellentesque nec nam aliquam sem et tortor consequat id. Felis bibendum ut tristique et egestas. Bibendum est ultricies integer quis auctor. Magna fringilla urna porttitor rhoncus dolor purus non enim. Molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed. Dolor sit amet consectetur adipiscing. Urna cursus eget nunc scelerisque. Non curabitur gravida arcu ac tortor dignissim convallis aenean et.\n" +
          "\n" +
          "Mauris vitae ultricies leo integer malesuada nunc vel risus commodo. Nibh cras pulvinar mattis nunc sed. Arcu non sodales neque sodales. Amet mauris commodo quis imperdiet. Eget velit aliquet sagittis id consectetur purus ut faucibus pulvinar. Justo laoreet sit amet cursus sit amet dictum sit. Senectus et netus et malesuada fames ac. Netus et malesuada fames ac turpis egestas integer eget aliquet. Condimentum lacinia quis vel eros donec ac odio. Condimentum lacinia quis vel eros donec ac odio tempor. Pellentesque adipiscing commodo elit at imperdiet dui accumsan sit amet. Posuere morbi leo urna molestie at elementum. Risus feugiat in ante metus dictum at tempor.\n" +
          "\n" +
          "Amet cursus sit amet dictum sit amet justo. Venenatis a condimentum vitae sapien. Tempus iaculis urna id volutpat lacus. Risus nullam eget felis eget nunc lobortis mattis. Elit sed vulputate mi sit amet mauris commodo quis. Nulla pharetra diam sit amet nisl suscipit. Aliquam etiam erat velit scelerisque in dictum non consectetur. Nibh tortor id aliquet lectus proin nibh nisl. Quis blandit turpis cursus in hac habitasse. Ac tortor dignissim convallis aenean et. Ornare quam viverra orci sagittis eu volutpat.\n" +
          "\n" +
          "Donec ultrices tincidunt arcu non sodales neque sodales. Commodo elit at imperdiet dui. Ante metus dictum at tempor. Feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Mauris ultrices eros in cursus turpis. Ipsum a arcu cursus vitae congue mauris. Sit amet nisl suscipit adipiscing bibendum est. Volutpat diam ut venenatis tellus. Dolor sit amet consectetur adipiscing elit pellentesque habitant. Egestas congue quisque egestas diam in arcu cursus euismod. Libero nunc consequat interdum varius sit amet. Leo vel orci porta non pulvinar neque. Nibh praesent tristique magna sit amet. Fusce id velit ut tortor pretium. Semper risus in hendrerit gravida rutrum. Elementum eu facilisis sed odio morbi quis. Urna molestie at elementum eu facilisis sed. Pulvinar proin gravida hendrerit lectus a. Nibh mauris cursus mattis molestie a iaculis.\n" +
          "\n" +
          "Ut enim blandit volutpat maecenas volutpat blandit aliquam etiam. Amet dictum sit amet justo donec enim diam vulputate ut. Ultrices neque ornare aenean euismod elementum nisi quis eleifend. Mi proin sed libero enim sed faucibus turpis in. Egestas purus viverra accumsan in. Maecenas pharetra convallis posuere morbi leo. Condimentum vitae sapien pellentesque habitant morbi tristique senectus. Ac auctor augue mauris augue neque gravida in fermentum et. Eget est lorem ipsum dolor sit amet. Mauris rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar. Vitae purus faucibus ornare suspendisse sed nisi lacus sed viverra. Aenean vel elit scelerisque mauris pellentesque. In ornare quam viverra orci sagittis eu volutpat odio facilisis. Non curabitur gravida arcu ac tortor. Mi tempus imperdiet nulla malesuada pellentesque. Parturient montes nascetur ridiculus mus mauris vitae ultricies leo integer. Nulla posuere sollicitudin aliquam ultrices sagittis orci. Orci phasellus egestas tellus rutrum tellus.\n" +
          "\n" +
          "Enim sed faucibus turpis in. Aliquam faucibus purus in massa. Consectetur lorem donec massa sapien faucibus et molestie ac feugiat. Tortor vitae purus faucibus ornare suspendisse sed. Ornare quam viverra orci sagittis eu volutpat. Consectetur purus ut faucibus pulvinar. Condimentum id venenatis a condimentum vitae sapien pellentesque. Donec pretium vulputate sapien nec sagittis aliquam malesuada bibendum. Dui nunc mattis enim ut tellus elementum. Nec feugiat nisl pretium fusce. Dapibus ultrices in iaculis nunc sed. Eget nullam non nisi est sit amet facilisis magna. Suspendisse in est ante in nibh. Gravida dictum fusce ut placerat orci nulla pellentesque. Amet est placerat in egestas erat imperdiet. Adipiscing elit pellentesque habitant morbi tristique senectus et. Ultricies mi eget mauris pharetra et ultrices neque ornare aenean. Facilisis volutpat est velit egestas. Massa sed elementum tempus egestas sed.\n" +
          "\n" +
          "Urna molestie at elementum eu facilisis sed. Mauris sit amet massa vitae. Quam vulputate dignissim suspendisse in est ante in nibh mauris. Magna sit amet purus gravida quis blandit turpis cursus in. Morbi non arcu risus quis. Augue lacus viverra vitae congue eu consequat. Nibh praesent tristique magna sit amet purus gravida quis. Diam sit amet nisl suscipit adipiscing bibendum est. Dignissim diam quis enim lobortis scelerisque fermentum. Donec massa sapien faucibus et molestie ac feugiat sed. Id neque aliquam vestibulum morbi blandit cursus risus at. Vitae tortor condimentum lacinia quis vel. Pellentesque adipiscing commodo elit at imperdiet dui.\n" +
          "\n" +
          "Viverra suspendisse potenti nullam ac tortor vitae purus. Amet porttitor eget dolor morbi non arcu. Felis eget nunc lobortis mattis aliquam faucibus purus in massa. Vestibulum lorem sed risus ultricies tristique. Placerat orci nulla pellentesque dignissim enim sit amet venenatis. Nisi porta lorem mollis aliquam. Sed arcu non odio euismod. Scelerisque eu ultrices vitae auctor. Aliquet enim tortor at auctor urna nunc id. Lacus vestibulum sed arcu non odio. Vel pharetra vel turpis nunc eget lorem. Commodo elit at imperdiet dui accumsan sit amet nulla.\n" +
          "\n" +
          "Odio pellentesque diam volutpat commodo. Lectus nulla at volutpat diam ut venenatis. Aenean euismod elementum nisi quis eleifend quam adipiscing vitae proin. Metus dictum at tempor commodo ullamcorper a lacus. Turpis massa tincidunt dui ut ornare lectus sit amet. Suscipit tellus mauris a diam maecenas. Turpis tincidunt id aliquet risus feugiat. Faucibus turpis in eu mi. Tellus elementum sagittis vitae et leo duis ut diam. Eu mi bibendum neque egestas congue quisque egestas diam in. Ut sem nulla pharetra diam sit. Praesent elementum facilisis leo vel fringilla. Blandit massa enim nec dui nunc mattis enim. Sed enim ut sem viverra aliquet eget.\n" +
          "\n" +
          "Pharetra massa massa ultricies mi quis hendrerit dolor. Nullam ac tortor vitae purus faucibus. Lobortis elementum nibh tellus molestie nunc non. Senectus et netus et malesuada fames. Rhoncus est pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat. Ipsum a arcu cursus vitae. Ac feugiat sed lectus vestibulum mattis. Aliquet nec ullamcorper sit amet risus nullam. Egestas fringilla phasellus faucibus scelerisque. Euismod elementum nisi quis eleifend quam adipiscing vitae proin. Scelerisque fermentum dui faucibus in ornare quam viverra orci. Viverra accumsan in nisl nisi scelerisque eu.\n" +
          "\n" +
          "Faucibus turpis in eu mi bibendum. Sed egestas egestas fringilla phasellus faucibus. Lectus mauris ultrices eros in cursus turpis massa. Mauris ultrices eros in cursus turpis massa tincidunt dui. Arcu cursus vitae congue mauris rhoncus aenean. Elementum facilisis leo vel fringilla est ullamcorper. Ut pharetra sit amet aliquam. Pulvinar pellentesque habitant morbi tristique. Risus feugiat in ante metus. Varius morbi enim nunc faucibus a. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque. Odio ut sem nulla pharetra diam sit amet nisl. Lacinia at quis risus sed vulputate odio ut. Libero nunc consequat interdum varius sit amet mattis. Vel orci porta non pulvinar neque laoreet.\n" +
          "\n" +
          "Ullamcorper morbi tincidunt ornare massa eget egestas purus viverra accumsan. Adipiscing tristique risus nec feugiat. Ac turpis egestas sed tempus urna et. Et malesuada fames ac turpis egestas. Pretium aenean pharetra magna ac placerat vestibulum. Maecenas accumsan lacus vel facilisis volutpat est velit. Pharetra et ultrices neque ornare aenean euismod elementum nisi quis. Volutpat commodo sed egestas egestas fringilla. Pretium quam vulputate dignissim suspendisse in est ante in nibh. Tempus egestas sed sed risus.\n" +
          "\n" +
          "Varius duis at consectetur lorem donec. Sollicitudin aliquam ultrices sagittis orci a scelerisque purus semper eget. Lectus urna duis convallis convallis tellus id interdum. Iaculis nunc sed augue lacus viverra vitae congue eu consequat. Accumsan lacus vel facilisis volutpat est velit. Sed id semper risus in. Proin fermentum leo vel orci porta non pulvinar. Mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Sed arcu non odio euismod lacinia at quis risus sed. In mollis nunc sed id. Tristique risus nec feugiat in fermentum. Massa placerat duis ultricies lacus sed turpis tincidunt id aliquet. Et sollicitudin ac orci phasellus egestas tellus rutrum tellus. Aliquam ultrices sagittis orci a scelerisque purus semper.\n" +
          "\n" +
          "Porta non pulvinar neque laoreet suspendisse interdum consectetur libero. Pretium nibh ipsum consequat nisl. Habitasse platea dictumst quisque sagittis purus sit amet volutpat consequat. Nunc sed augue lacus viverra vitae congue eu consequat. Dictum non consectetur a erat nam. Turpis egestas maecenas pharetra convallis posuere. Duis convallis convallis tellus id interdum velit laoreet. Lorem sed risus ultricies tristique nulla aliquet enim tortor. Placerat orci nulla pellentesque dignissim enim sit amet venenatis urna. Sagittis vitae et leo duis ut. Vulputate ut pharetra sit amet aliquam id diam. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Scelerisque purus semper eget duis at tellus. Ut consequat semper viverra nam. Tincidunt ornare massa eget egestas. Adipiscing elit ut aliquam purus sit amet luctus. Dolor purus non enim praesent elementum. Vitae tempus quam pellentesque nec nam aliquam sem et tortor. Habitasse platea dictumst vestibulum rhoncus. Sem integer vitae justo eget magna.\n" +
          "\n" +
          "Non blandit massa enim nec dui nunc. Vitae aliquet nec ullamcorper sit. Lorem dolor sed viverra ipsum nunc. Amet porttitor eget dolor morbi. Est ullamcorper eget nulla facilisi etiam dignissim diam. Consequat semper viverra nam libero justo laoreet sit amet cursus. Vivamus arcu felis bibendum ut tristique et egestas quis ipsum. Curabitur vitae nunc sed velit dignissim sodales ut. Risus ultricies tristique nulla aliquet enim. Pellentesque pulvinar pellentesque habitant morbi tristique senectus et. Duis at consectetur lorem donec massa sapien faucibus et molestie. Praesent tristique magna sit amet purus gravida quis. Mauris rhoncus aenean vel elit scelerisque. Id aliquet lectus proin nibh nisl condimentum id venenatis. Phasellus egestas tellus rutrum tellus pellentesque eu. Lorem ipsum dolor sit amet consectetur adipiscing elit.\n" +
          "\n" +
          "A cras semper auctor neque. Ornare arcu odio ut sem nulla pharetra diam sit. Pretium nibh ipsum consequat nisl vel. Viverra nam libero justo laoreet sit amet cursus sit. Arcu vitae elementum curabitur vitae nunc sed velit dignissim sodales. Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Leo vel orci porta non. Dui vivamus arcu felis bibendum. Nulla facilisi nullam vehicula ipsum a arcu cursus vitae congue. Et molestie ac feugiat sed lectus. Aliquam faucibus purus in massa tempor nec feugiat nisl.\n" +
          "\n" +
          "Vitae et leo duis ut diam quam nulla. Id interdum velit laoreet id donec ultrices tincidunt arcu non. Eget nunc scelerisque viverra mauris in aliquam sem fringilla ut. Sit amet facilisis magna etiam tempor orci. Odio eu feugiat pretium nibh ipsum consequat. Neque aliquam vestibulum morbi blandit cursus risus at ultrices mi. Vestibulum lectus mauris ultrices eros in cursus. Venenatis a condimentum vitae sapien pellentesque habitant morbi tristique. Tristique nulla aliquet enim tortor at auctor urna nunc. Commodo elit at imperdiet dui accumsan. Iaculis urna id volutpat lacus laoreet non curabitur. Quis eleifend quam adipiscing vitae.\n" +
          "\n" +
          "Vitae auctor eu augue ut lectus arcu bibendum. Pharetra convallis posuere morbi leo urna. Vitae justo eget magna fermentum iaculis eu non diam phasellus. Et pharetra pharetra massa massa ultricies. Aliquam vestibulum morbi blandit cursus. Etiam sit amet nisl purus in. Nunc consequat interdum varius sit. Diam sit amet nisl suscipit adipiscing bibendum. Nunc mattis enim ut tellus elementum. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Sed nisi lacus sed viverra. Diam quam nulla porttitor massa id neque aliquam vestibulum. Duis at tellus at urna condimentum mattis pellentesque.\n" +
          "\n" +
          "Tincidunt eget nullam non nisi est sit amet. Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis. Fusce id velit ut tortor. Sit amet purus gravida quis. Urna nec tincidunt praesent semper. Volutpat commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Tristique magna sit amet purus gravida quis blandit turpis. Ut sem viverra aliquet eget sit amet tellus cras adipiscing. Blandit libero volutpat sed cras ornare arcu dui vivamus. Ullamcorper a lacus vestibulum sed arcu non odio euismod.\n" +
          "\n" +
          "Leo vel orci porta non. Eu consequat ac felis donec et. Netus et malesuada fames ac turpis egestas sed tempus urna. Eget lorem dolor sed viverra ipsum nunc. Maecenas sed enim ut sem viverra. Vel orci porta non pulvinar neque. At tempor commodo ullamcorper a lacus vestibulum sed arcu. Lobortis elementum nibh tellus molestie nunc non. Pellentesque nec nam aliquam sem et tortor consequat. Interdum varius sit amet mattis vulputate enim nulla aliquet porttitor. Turpis egestas pretium aenean pharetra. Ipsum dolor sit amet consectetur adipiscing elit. Sollicitudin tempor id eu nisl nunc mi. Tellus mauris a diam maecenas sed enim ut sem viverra. Ut morbi tincidunt augue interdum velit euismod in pellentesque massa. Tortor aliquam nulla facilisi cras. Adipiscing tristique risus nec feugiat in fermentum posuere urna. Lacus laoreet non curabitur gravida arcu ac tortor dignissim convallis. Augue mauris augue neque gravida in fermentum et. Commodo viverra maecenas accumsan lacus vel facilisis volutpat est.\n" +
          "\n" +
          "Elit pellentesque habitant morbi tristique. Sollicitudin nibh sit amet commodo nulla. Ipsum faucibus vitae aliquet nec ullamcorper. In nibh mauris cursus mattis molestie a iaculis at erat. Vitae elementum curabitur vitae nunc sed velit. Duis ultricies lacus sed turpis tincidunt. Nibh venenatis cras sed felis eget velit. Tellus at urna condimentum mattis. Enim nunc faucibus a pellentesque sit amet porttitor eget. Sit amet justo donec enim diam. Ac placerat vestibulum lectus mauris ultrices eros in cursus. Sit amet est placerat in egestas erat imperdiet sed. Eget nulla facilisi etiam dignissim diam quis enim lobortis scelerisque. Elit pellentesque habitant morbi tristique senectus et netus. Lectus arcu bibendum at varius vel pharetra. Nam at lectus urna duis convallis convallis. Commodo nulla facilisi nullam vehicula ipsum a. Arcu odio ut sem nulla pharetra diam sit amet nisl. Adipiscing commodo elit at imperdiet dui accumsan sit. In vitae turpis massa sed elementum tempus egestas.\n" +
          "\n" +
          "Quis blandit turpis cursus in hac habitasse platea dictumst quisque. Felis eget velit aliquet sagittis id consectetur. Morbi tristique senectus et netus. Nisi quis eleifend quam adipiscing. Ac orci phasellus egestas tellus rutrum tellus pellentesque. Etiam sit amet nisl purus in mollis. Amet volutpat consequat mauris nunc congue nisi. Nunc aliquet bibendum enim facilisis gravida neque convallis. Scelerisque felis imperdiet proin fermentum leo. Varius quam quisque id diam vel quam elementum pulvinar etiam. Lorem mollis aliquam ut porttitor leo a diam sollicitudin. Ipsum dolor sit amet consectetur adipiscing. Mauris nunc congue nisi vitae suscipit.\n" +
          "\n" +
          "Purus gravida quis blandit turpis cursus in. At in tellus integer feugiat scelerisque. Rhoncus urna neque viverra justo nec ultrices dui. Morbi tristique senectus et netus et malesuada fames ac. At lectus urna duis convallis. Mi bibendum neque egestas congue quisque egestas diam. Volutpat diam ut venenatis tellus in metus vulputate eu scelerisque. Purus semper eget duis at tellus at urna condimentum mattis. Natoque penatibus et magnis dis parturient montes nascetur ridiculus. Nulla facilisi etiam dignissim diam. Elementum sagittis vitae et leo duis ut diam. Faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis. Lobortis elementum nibh tellus molestie. Cras tincidunt lobortis feugiat vivamus at augue eget arcu. Fames ac turpis egestas integer eget aliquet nibh praesent. Sagittis vitae et leo duis ut diam. Viverra mauris in aliquam sem fringilla ut morbi tincidunt augue. Donec ac odio tempor orci dapibus ultrices in iaculis. Faucibus a pellentesque sit amet porttitor. Sem et tortor consequat id porta nibh venenatis cras sed.\n" +
          "\n" +
          "Lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque. Est ante in nibh mauris cursus mattis molestie a iaculis. Et malesuada fames ac turpis egestas sed tempus urna. Sagittis purus sit amet volutpat. Pellentesque elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at. Proin fermentum leo vel orci porta non. Aliquam etiam erat velit scelerisque. Convallis a cras semper auctor. Cras fermentum odio eu feugiat pretium nibh ipsum. Lacus sed viverra tellus in hac habitasse. Amet risus nullam eget felis eget nunc lobortis. Magnis dis parturient montes nascetur ridiculus mus mauris. Tortor vitae purus faucibus ornare suspendisse. Justo laoreet sit amet cursus sit amet dictum sit amet. Nam aliquam sem et tortor consequat id porta.\n" +
          "\n" +
          "Vitae proin sagittis nisl rhoncus mattis rhoncus. Tempor nec feugiat nisl pretium fusce. Neque sodales ut etiam sit. Quis vel eros donec ac odio. Habitant morbi tristique senectus et. Metus vulputate eu scelerisque felis. Eget sit amet tellus cras adipiscing enim eu turpis. Euismod in pellentesque massa placerat duis ultricies lacus sed turpis. Sagittis aliquam malesuada bibendum arcu. Sed arcu non odio euismod lacinia at quis. Gravida neque convallis a cras semper auctor neque vitae tempus. Amet justo donec enim diam vulputate ut pharetra. Enim eu turpis egestas pretium aenean pharetra magna ac placerat. In mollis nunc sed id semper. Bibendum ut tristique et egestas quis ipsum suspendisse ultrices gravida. Urna molestie at elementum eu facilisis sed. Amet purus gravida quis blandit turpis cursus in hac habitasse. Viverra mauris in aliquam sem fringilla ut morbi.\n" +
          "\n" +
          "Auctor eu augue ut lectus arcu bibendum at. Diam quam nulla porttitor massa id neque aliquam. Ut consequat semper viverra nam libero justo laoreet sit. Imperdiet proin fermentum leo vel orci porta. Nibh cras pulvinar mattis nunc sed. Neque volutpat ac tincidunt vitae semper. Mauris in aliquam sem fringilla ut morbi. Id leo in vitae turpis massa. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras. Sed elementum tempus egestas sed sed risus. Id consectetur purus ut faucibus. Tincidunt augue interdum velit euismod in pellentesque massa placerat. Quam nulla porttitor massa id. Curabitur vitae nunc sed velit dignissim sodales ut eu sem. Enim ut sem viverra aliquet eget sit amet tellus. Diam quam nulla porttitor massa. Bibendum enim facilisis gravida neque convallis. Molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit sed.\n" +
          "\n" +
          "Lacinia at quis risus sed vulputate odio ut. Volutpat lacus laoreet non curabitur. Donec massa sapien faucibus et molestie ac feugiat sed lectus. At lectus urna duis convallis convallis tellus id. Gravida quis blandit turpis cursus in hac habitasse platea dictumst. Et ligula ullamcorper malesuada proin libero. Nisl condimentum id venenatis a condimentum vitae sapien pellentesque. Placerat in egestas erat imperdiet sed euismod nisi porta lorem. Id ornare arcu odio ut. Tellus mauris a diam maecenas sed enim ut sem. Adipiscing commodo elit at imperdiet dui accumsan sit amet. In iaculis nunc sed augue lacus viverra. Massa tincidunt dui ut ornare lectus sit amet. Sodales ut eu sem integer vitae. Morbi leo urna molestie at elementum eu. Ornare lectus sit amet est placerat in egestas. Non pulvinar neque laoreet suspendisse.\n" +
          "\n" +
          "Malesuada fames ac turpis egestas. Consectetur a erat nam at lectus urna duis convallis convallis. Arcu felis bibendum ut tristique et egestas quis. Fermentum odio eu feugiat pretium nibh ipsum. Duis at consectetur lorem donec massa sapien. Duis ultricies lacus sed turpis tincidunt id aliquet risus feugiat. Id neque aliquam vestibulum morbi blandit cursus risus at. Commodo nulla facilisi nullam vehicula ipsum a. Nunc mattis enim ut tellus elementum. Proin sagittis nisl rhoncus mattis. Enim ut sem viverra aliquet eget sit amet. Sed euismod nisi porta lorem.\n" +
          "\n" +
          "Enim facilisis gravida neque convallis a cras semper auctor neque. Diam sollicitudin tempor id eu nisl. Magna fringilla urna porttitor rhoncus dolor purus non enim praesent. Vitae proin sagittis nisl rhoncus mattis rhoncus urna. Luctus accumsan tortor posuere ac ut consequat semper viverra nam. Ultrices eros in cursus turpis massa tincidunt. Odio pellentesque diam volutpat commodo sed egestas. Augue neque gravida in fermentum et sollicitudin ac. Suscipit adipiscing bibendum est ultricies integer quis. Nunc non blandit massa enim nec dui nunc mattis. Morbi quis commodo odio aenean sed adipiscing diam. Tellus at urna condimentum mattis pellentesque id nibh tortor. At augue eget arcu dictum varius duis at. Varius morbi enim nunc faucibus a pellentesque sit amet porttitor. Nec feugiat in fermentum posuere urna nec. Fames ac turpis egestas maecenas pharetra convallis posuere. Arcu cursus euismod quis viverra nibh cras pulvinar mattis. Quam quisque id diam vel quam elementum pulvinar etiam. Porta non pulvinar neque laoreet suspendisse interdum consectetur libero. Parturient montes nascetur ridiculus mus mauris vitae ultricies.\n" +
          "\n" +
          "Vel facilisis volutpat est velit egestas dui id ornare. Vulputate odio ut enim blandit volutpat. Congue quisque egestas diam in arcu cursus. Convallis aenean et tortor at risus viverra adipiscing. Id consectetur purus ut faucibus pulvinar. Sollicitudin tempor id eu nisl nunc mi ipsum faucibus vitae. Accumsan in nisl nisi scelerisque eu ultrices vitae auctor. Urna molestie at elementum eu facilisis sed. Dui ut ornare lectus sit amet est placerat in. Ullamcorper a lacus vestibulum sed arcu non odio euismod. Vel quam elementum pulvinar etiam non. Adipiscing elit ut aliquam purus sit amet luctus venenatis.\n" +
          "\n" +
          "Tincidunt tortor aliquam nulla facilisi. Aliquet eget sit amet tellus cras adipiscing enim eu. Amet purus gravida quis blandit turpis. Justo eget magna fermentum iaculis. Risus ultricies tristique nulla aliquet enim tortor at auctor urna. Purus ut faucibus pulvinar elementum integer enim neque volutpat. Mauris cursus mattis molestie a iaculis at. Dapibus ultrices in iaculis nunc sed augue. Bibendum ut tristique et egestas quis ipsum suspendisse ultrices. Amet massa vitae tortor condimentum lacinia. Consequat semper viverra nam libero justo laoreet sit amet cursus. Tristique senectus et netus et. Ultrices dui sapien eget mi proin sed libero. Posuere sollicitudin aliquam ultrices sagittis orci a scelerisque. Ante in nibh mauris cursus mattis molestie a iaculis at.\n" +
          "\n" +
          "Quis eleifend quam adipiscing vitae proin sagittis nisl rhoncus. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi. Lobortis feugiat vivamus at augue eget arcu dictum varius. Consequat mauris nunc congue nisi vitae suscipit tellus. Facilisis gravida neque convallis a cras semper auctor neque. Molestie a iaculis at erat. Quis vel eros donec ac. Morbi leo urna molestie at elementum. Morbi tristique senectus et netus et malesuada fames ac turpis. Faucibus vitae aliquet nec ullamcorper sit amet risus nullam eget. Odio tempor orci dapibus ultrices. Tristique et egestas quis ipsum suspendisse. Massa tempor nec feugiat nisl pretium fusce id velit. Enim nulla aliquet porttitor lacus luctus accumsan tortor. Eu volutpat odio facilisis mauris sit amet massa vitae.\n" +
          "\n" +
          "Ut eu sem integer vitae justo eget magna fermentum. Netus et malesuada fames ac turpis egestas. Volutpat lacus laoreet non curabitur gravida arcu ac. Tincidunt lobortis feugiat vivamus at augue. Vitae turpis massa sed elementum tempus egestas. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci. Eu scelerisque felis imperdiet proin fermentum leo vel orci porta. Tempus egestas sed sed risus pretium quam vulputate. Adipiscing tristique risus nec feugiat in. Elementum eu facilisis sed odio morbi quis. Nam libero justo laoreet sit amet cursus sit. Scelerisque in dictum non consectetur a erat nam at lectus. Viverra maecenas accumsan lacus vel. Faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper. Fames ac turpis egestas maecenas.\n" +
          "\n" +
          "Sit amet tellus cras adipiscing enim eu turpis egestas. Quis varius quam quisque id diam vel quam elementum pulvinar. Semper feugiat nibh sed pulvinar proin gravida hendrerit lectus a. Tortor posuere ac ut consequat semper viverra nam libero justo. Egestas fringilla phasellus faucibus scelerisque. Feugiat nibh sed pulvinar proin. Cum sociis natoque penatibus et magnis dis parturient. Arcu felis bibendum ut tristique et egestas quis ipsum. Odio morbi quis commodo odio aenean sed adipiscing diam. At risus viverra adipiscing at in tellus integer. Lacus sed viverra tellus in hac habitasse platea dictumst vestibulum. Dui id ornare arcu odio ut sem nulla pharetra. Elementum pulvinar etiam non quam lacus suspendisse faucibus interdum. At imperdiet dui accumsan sit amet nulla facilisi. Ultricies lacus sed turpis tincidunt. Egestas erat imperdiet sed euismod nisi porta. Accumsan in nisl nisi scelerisque eu ultrices vitae. Pharetra sit amet aliquam id. Iaculis urna id volutpat lacus laoreet.\n" +
          "\n" +
          "Morbi leo urna molestie at elementum. Tellus integer feugiat scelerisque varius morbi. Eu nisl nunc mi ipsum faucibus. Cras semper auctor neque vitae tempus quam pellentesque. Magna fermentum iaculis eu non diam. Mauris ultrices eros in cursus turpis massa tincidunt. Congue nisi vitae suscipit tellus mauris. Nam at lectus urna duis convallis convallis. Quam lacus suspendisse faucibus interdum posuere lorem ipsum. Quis hendrerit dolor magna eget est lorem. Pellentesque adipiscing commodo elit at imperdiet dui. Varius sit amet mattis vulputate enim nulla aliquet porttitor. Ornare arcu odio ut sem nulla pharetra diam sit. Nisi scelerisque eu ultrices vitae. Pharetra pharetra massa massa ultricies mi quis hendrerit. Porta nibh venenatis cras sed felis eget velit. Volutpat consequat mauris nunc congue nisi. Fames ac turpis egestas sed tempus urna.\n" +
          "\n" +
          "Fermentum leo vel orci porta non pulvinar neque laoreet. Faucibus ornare suspendisse sed nisi lacus sed. Turpis massa sed elementum tempus egestas sed. Donec et odio pellentesque diam volutpat commodo sed. Id cursus metus aliquam eleifend mi in. Odio ut enim blandit volutpat maecenas volutpat blandit aliquam. Porttitor massa id neque aliquam vestibulum morbi blandit cursus. Turpis cursus in hac habitasse platea dictumst quisque. Eget nunc scelerisque viverra mauris in aliquam sem fringilla. Nec dui nunc mattis enim ut. Nisi scelerisque eu ultrices vitae auctor eu augue ut lectus. Semper auctor neque vitae tempus quam pellentesque nec nam. Neque ornare aenean euismod elementum nisi quis.\n" +
          "\n" +
          "Nulla facilisi cras fermentum odio eu feugiat. Duis at consectetur lorem donec massa. Praesent semper feugiat nibh sed pulvinar proin. Ullamcorper a lacus vestibulum sed arcu non odio euismod lacinia. Enim diam vulputate ut pharetra sit amet. Nunc faucibus a pellentesque sit amet porttitor eget. Massa ultricies mi quis hendrerit dolor magna eget est. Pulvinar mattis nunc sed blandit libero. Vitae nunc sed velit dignissim sodales. Parturient montes nascetur ridiculus mus mauris vitae ultricies. Eget felis eget nunc lobortis mattis aliquam faucibus purus in. Facilisi nullam vehicula ipsum a arcu cursus. Enim diam vulputate ut pharetra sit amet. Sed risus pretium quam vulputate dignissim suspendisse in. Gravida quis blandit turpis cursus. Mattis pellentesque id nibh tortor.\n" +
          "\n" +
          "Ut pharetra sit amet aliquam id. Dolor sed viverra ipsum nunc aliquet. Purus viverra accumsan in nisl nisi scelerisque eu. Ultrices tincidunt arcu non sodales neque sodales ut. Nunc vel risus commodo viverra maecenas accumsan lacus. Sem et tortor consequat id porta nibh venenatis cras. Fermentum odio eu feugiat pretium nibh ipsum consequat nisl. At tellus at urna condimentum mattis pellentesque id nibh tortor. Pharetra et ultrices neque ornare. Vitae tortor condimentum lacinia quis vel eros donec ac. Ornare suspendisse sed nisi lacus sed viverra tellus. Sagittis id consectetur purus ut faucibus. Volutpat sed cras ornare arcu dui. Erat pellentesque adipiscing commodo elit at imperdiet. Laoreet suspendisse interdum consectetur libero.\n" +
          "\n" +
          "Neque egestas congue quisque egestas. Elit ullamcorper dignissim cras tincidunt lobortis. Nisi scelerisque eu ultrices vitae auctor eu augue. Ut tellus elementum sagittis vitae et leo. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed. Sollicitudin aliquam ultrices sagittis orci a scelerisque. Senectus et netus et malesuada fames ac turpis egestas integer. Duis ut diam quam nulla porttitor massa. Commodo nulla facilisi nullam vehicula ipsum a arcu cursus. A arcu cursus vitae congue mauris rhoncus aenean. At consectetur lorem donec massa sapien faucibus et molestie ac. Sed blandit libero volutpat sed. Elit scelerisque mauris pellentesque pulvinar. Odio morbi quis commodo odio aenean sed adipiscing diam donec. Cursus in hac habitasse platea dictumst quisque sagittis purus sit. Nam libero justo laoreet sit amet cursus. Mollis nunc sed id semper risus. Pharetra convallis posuere morbi leo urna molestie at elementum.\n" +
          "\n" +
          "Ullamcorper morbi tincidunt ornare massa eget egestas purus. A scelerisque purus semper eget duis at tellus at urna. Velit sed ullamcorper morbi tincidunt. Sagittis nisl rhoncus mattis rhoncus urna neque viverra justo nec. Quam id leo in vitae. Ornare arcu dui vivamus arcu felis bibendum ut tristique et. Lectus proin nibh nisl condimentum id venenatis. Mauris a diam maecenas sed enim ut sem viverra. Feugiat nisl pretium fusce id velit. Vitae turpis massa sed elementum tempus egestas. Diam ut venenatis tellus in metus vulputate. Fermentum posuere urna nec tincidunt. Auctor urna nunc id cursus metus aliquam.\n";
  
  private static final String BASE64_LARGE_TEXT =
      "TG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdCwg\r\n" +
          "c2VkIGRvIGVpdXNtb2QgdGVtcG9yIGluY2lkaWR1bnQgdXQgbGFib3JlIGV0IGRvbG9yZSBtYWdu\r\n" +
          "YSBhbGlxdWEuIENvbW1vZG8gcXVpcyBpbXBlcmRpZXQgbWFzc2EgdGluY2lkdW50IG51bmMgcHVs\r\n" +
          "dmluYXIgc2FwaWVuIGV0IGxpZ3VsYS4gSWFjdWxpcyBldSBub24gZGlhbSBwaGFzZWxsdXMgdmVz\r\n" +
          "dGlidWx1bSBsb3JlbSBzZWQgcmlzdXMgdWx0cmljaWVzLiBWaXRhZSBhbGlxdWV0IG5lYyB1bGxh\r\n" +
          "bWNvcnBlciBzaXQgYW1ldCByaXN1cyBudWxsYW0gZWdldC4gVnVscHV0YXRlIGV1IHNjZWxlcmlz\r\n" +
          "cXVlIGZlbGlzIGltcGVyZGlldCBwcm9pbiBmZXJtZW50dW0gbGVvIHZlbC4gU2VkIGNyYXMgb3Ju\r\n" +
          "YXJlIGFyY3UgZHVpIHZpdmFtdXMgYXJjdSBmZWxpcyBiaWJlbmR1bS4gTnVsbGEgZmFjaWxpc2kg\r\n" +
          "bW9yYmkgdGVtcHVzIGlhY3VsaXMgdXJuYSBpZC4gTG9ib3J0aXMgZWxlbWVudHVtIG5pYmggdGVs\r\n" +
          "bHVzIG1vbGVzdGllIG51bmMgbm9uIGJsYW5kaXQuIEV1IG1pIGJpYmVuZHVtIG5lcXVlIGVnZXN0\r\n" +
          "YXMuIEEgY29uZGltZW50dW0gdml0YWUgc2FwaWVuIHBlbGxlbnRlc3F1ZSBoYWJpdGFudC4KClBv\r\n" +
          "c3VlcmUgYWMgdXQgY29uc2VxdWF0IHNlbXBlciB2aXZlcnJhLiBNYXNzYSB2aXRhZSB0b3J0b3Ig\r\n" +
          "Y29uZGltZW50dW0gbGFjaW5pYSBxdWlzIHZlbC4gU3VzcGVuZGlzc2Ugc2VkIG5pc2kgbGFjdXMg\r\n" +
          "c2VkIHZpdmVycmEgdGVsbHVzIGluLiBWZWxpdCBkaWduaXNzaW0gc29kYWxlcyB1dCBldSBzZW0g\r\n" +
          "aW50ZWdlciB2aXRhZSBqdXN0byBlZ2V0LiBTdXNwZW5kaXNzZSBmYXVjaWJ1cyBpbnRlcmR1bSBw\r\n" +
          "b3N1ZXJlIGxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0IGNvbnNlY3RldHVyLiBJbnRlZ2VyIG1h\r\n" +
          "bGVzdWFkYSBudW5jIHZlbCByaXN1cyBjb21tb2RvIHZpdmVycmEgbWFlY2VuYXMgYWNjdW1zYW4u\r\n" +
          "IFNpdCBhbWV0IHZvbHV0cGF0IGNvbnNlcXVhdCBtYXVyaXMgbnVuYyBjb25ndWUgbmlzaSB2aXRh\r\n" +
          "ZS4gRGlnbmlzc2ltIHN1c3BlbmRpc3NlIGluIGVzdCBhbnRlIGluIG5pYmguIE1hZ25hIGZlcm1l\r\n" +
          "bnR1bSBpYWN1bGlzIGV1IG5vbiBkaWFtIHBoYXNlbGx1cyB2ZXN0aWJ1bHVtIGxvcmVtIHNlZC4g\r\n" +
          "VmVzdGlidWx1bSByaG9uY3VzIGVzdCBwZWxsZW50ZXNxdWUgZWxpdCB1bGxhbWNvcnBlci4gRWdl\r\n" +
          "c3RhcyBkaWFtIGluIGFyY3UgY3Vyc3VzIGV1aXNtb2QgcXVpcyB2aXZlcnJhIG5pYmggY3Jhcy4g\r\n" +
          "UHVydXMgZmF1Y2lidXMgb3JuYXJlIHN1c3BlbmRpc3NlIHNlZCBuaXNpIGxhY3VzIHNlZC4gRHVp\r\n" +
          "IGZhdWNpYnVzIGluIG9ybmFyZSBxdWFtIHZpdmVycmEuIExhb3JlZXQgaWQgZG9uZWMgdWx0cmlj\r\n" +
          "ZXMgdGluY2lkdW50IGFyY3Ugbm9uIHNvZGFsZXMgbmVxdWUgc29kYWxlcy4gRXQgbWFsZXN1YWRh\r\n" +
          "IGZhbWVzIGFjIHR1cnBpcy4KCkxhY2luaWEgYXQgcXVpcyByaXN1cyBzZWQgdnVscHV0YXRlIG9k\r\n" +
          "aW8gdXQuIFB1cnVzIHZpdmVycmEgYWNjdW1zYW4gaW4gbmlzbCBuaXNpIHNjZWxlcmlzcXVlIGV1\r\n" +
          "IHVsdHJpY2VzIHZpdGFlLiBJbiBwZWxsZW50ZXNxdWUgbWFzc2EgcGxhY2VyYXQgZHVpcy4gTWFn\r\n" +
          "bmEgZmVybWVudHVtIGlhY3VsaXMgZXUgbm9uIGRpYW0gcGhhc2VsbHVzLiBVbHRyaWNlcyBkdWkg\r\n" +
          "c2FwaWVuIGVnZXQgbWkgcHJvaW4gc2VkIGxpYmVybyBlbmltLiBQZWxsZW50ZXNxdWUgaWQgbmli\r\n" +
          "aCB0b3J0b3IgaWQgYWxpcXVldCBsZWN0dXMgcHJvaW4gbmliaCBuaXNsLiBNYXR0aXMgYWxpcXVh\r\n" +
          "bSBmYXVjaWJ1cyBwdXJ1cyBpbiBtYXNzYSB0ZW1wb3IuIEFtZXQgY29uc2VjdGV0dXIgYWRpcGlz\r\n" +
          "Y2luZyBlbGl0IHBlbGxlbnRlc3F1ZSBoYWJpdGFudCBtb3JiaSB0cmlzdGlxdWUgc2VuZWN0dXMu\r\n" +
          "IFBlbGxlbnRlc3F1ZSBtYXNzYSBwbGFjZXJhdCBkdWlzIHVsdHJpY2llcyBsYWN1cyBzZWQgdHVy\r\n" +
          "cGlzLiBTYWdpdHRpcyB2aXRhZSBldCBsZW8gZHVpcyB1dCBkaWFtIHF1YW0gbnVsbGEgcG9ydHRp\r\n" +
          "dG9yLiBRdWFtIHBlbGxlbnRlc3F1ZSBuZWMgbmFtIGFsaXF1YW0gc2VtIGV0IHRvcnRvciBjb25z\r\n" +
          "ZXF1YXQgaWQuIEZlbGlzIGJpYmVuZHVtIHV0IHRyaXN0aXF1ZSBldCBlZ2VzdGFzLiBCaWJlbmR1\r\n" +
          "bSBlc3QgdWx0cmljaWVzIGludGVnZXIgcXVpcyBhdWN0b3IuIE1hZ25hIGZyaW5naWxsYSB1cm5h\r\n" +
          "IHBvcnR0aXRvciByaG9uY3VzIGRvbG9yIHB1cnVzIG5vbiBlbmltLiBNb2xlc3RpZSBhYyBmZXVn\r\n" +
          "aWF0IHNlZCBsZWN0dXMgdmVzdGlidWx1bSBtYXR0aXMgdWxsYW1jb3JwZXIgdmVsaXQgc2VkLiBE\r\n" +
          "b2xvciBzaXQgYW1ldCBjb25zZWN0ZXR1ciBhZGlwaXNjaW5nLiBVcm5hIGN1cnN1cyBlZ2V0IG51\r\n" +
          "bmMgc2NlbGVyaXNxdWUuIE5vbiBjdXJhYml0dXIgZ3JhdmlkYSBhcmN1IGFjIHRvcnRvciBkaWdu\r\n" +
          "aXNzaW0gY29udmFsbGlzIGFlbmVhbiBldC4KCk1hdXJpcyB2aXRhZSB1bHRyaWNpZXMgbGVvIGlu\r\n" +
          "dGVnZXIgbWFsZXN1YWRhIG51bmMgdmVsIHJpc3VzIGNvbW1vZG8uIE5pYmggY3JhcyBwdWx2aW5h\r\n" +
          "ciBtYXR0aXMgbnVuYyBzZWQuIEFyY3Ugbm9uIHNvZGFsZXMgbmVxdWUgc29kYWxlcy4gQW1ldCBt\r\n" +
          "YXVyaXMgY29tbW9kbyBxdWlzIGltcGVyZGlldC4gRWdldCB2ZWxpdCBhbGlxdWV0IHNhZ2l0dGlz\r\n" +
          "IGlkIGNvbnNlY3RldHVyIHB1cnVzIHV0IGZhdWNpYnVzIHB1bHZpbmFyLiBKdXN0byBsYW9yZWV0\r\n" +
          "IHNpdCBhbWV0IGN1cnN1cyBzaXQgYW1ldCBkaWN0dW0gc2l0LiBTZW5lY3R1cyBldCBuZXR1cyBl\r\n" +
          "dCBtYWxlc3VhZGEgZmFtZXMgYWMuIE5ldHVzIGV0IG1hbGVzdWFkYSBmYW1lcyBhYyB0dXJwaXMg\r\n" +
          "ZWdlc3RhcyBpbnRlZ2VyIGVnZXQgYWxpcXVldC4gQ29uZGltZW50dW0gbGFjaW5pYSBxdWlzIHZl\r\n" +
          "bCBlcm9zIGRvbmVjIGFjIG9kaW8uIENvbmRpbWVudHVtIGxhY2luaWEgcXVpcyB2ZWwgZXJvcyBk\r\n" +
          "b25lYyBhYyBvZGlvIHRlbXBvci4gUGVsbGVudGVzcXVlIGFkaXBpc2NpbmcgY29tbW9kbyBlbGl0\r\n" +
          "IGF0IGltcGVyZGlldCBkdWkgYWNjdW1zYW4gc2l0IGFtZXQuIFBvc3VlcmUgbW9yYmkgbGVvIHVy\r\n" +
          "bmEgbW9sZXN0aWUgYXQgZWxlbWVudHVtLiBSaXN1cyBmZXVnaWF0IGluIGFudGUgbWV0dXMgZGlj\r\n" +
          "dHVtIGF0IHRlbXBvci4KCkFtZXQgY3Vyc3VzIHNpdCBhbWV0IGRpY3R1bSBzaXQgYW1ldCBqdXN0\r\n" +
          "by4gVmVuZW5hdGlzIGEgY29uZGltZW50dW0gdml0YWUgc2FwaWVuLiBUZW1wdXMgaWFjdWxpcyB1\r\n" +
          "cm5hIGlkIHZvbHV0cGF0IGxhY3VzLiBSaXN1cyBudWxsYW0gZWdldCBmZWxpcyBlZ2V0IG51bmMg\r\n" +
          "bG9ib3J0aXMgbWF0dGlzLiBFbGl0IHNlZCB2dWxwdXRhdGUgbWkgc2l0IGFtZXQgbWF1cmlzIGNv\r\n" +
          "bW1vZG8gcXVpcy4gTnVsbGEgcGhhcmV0cmEgZGlhbSBzaXQgYW1ldCBuaXNsIHN1c2NpcGl0LiBB\r\n" +
          "bGlxdWFtIGV0aWFtIGVyYXQgdmVsaXQgc2NlbGVyaXNxdWUgaW4gZGljdHVtIG5vbiBjb25zZWN0\r\n" +
          "ZXR1ci4gTmliaCB0b3J0b3IgaWQgYWxpcXVldCBsZWN0dXMgcHJvaW4gbmliaCBuaXNsLiBRdWlz\r\n" +
          "IGJsYW5kaXQgdHVycGlzIGN1cnN1cyBpbiBoYWMgaGFiaXRhc3NlLiBBYyB0b3J0b3IgZGlnbmlz\r\n" +
          "c2ltIGNvbnZhbGxpcyBhZW5lYW4gZXQuIE9ybmFyZSBxdWFtIHZpdmVycmEgb3JjaSBzYWdpdHRp\r\n" +
          "cyBldSB2b2x1dHBhdC4KCkRvbmVjIHVsdHJpY2VzIHRpbmNpZHVudCBhcmN1IG5vbiBzb2RhbGVz\r\n" +
          "IG5lcXVlIHNvZGFsZXMuIENvbW1vZG8gZWxpdCBhdCBpbXBlcmRpZXQgZHVpLiBBbnRlIG1ldHVz\r\n" +
          "IGRpY3R1bSBhdCB0ZW1wb3IuIEZldWdpYXQgc2VkIGxlY3R1cyB2ZXN0aWJ1bHVtIG1hdHRpcyB1\r\n" +
          "bGxhbWNvcnBlciB2ZWxpdCBzZWQgdWxsYW1jb3JwZXIuIE1hdXJpcyB1bHRyaWNlcyBlcm9zIGlu\r\n" +
          "IGN1cnN1cyB0dXJwaXMuIElwc3VtIGEgYXJjdSBjdXJzdXMgdml0YWUgY29uZ3VlIG1hdXJpcy4g\r\n" +
          "U2l0IGFtZXQgbmlzbCBzdXNjaXBpdCBhZGlwaXNjaW5nIGJpYmVuZHVtIGVzdC4gVm9sdXRwYXQg\r\n" +
          "ZGlhbSB1dCB2ZW5lbmF0aXMgdGVsbHVzLiBEb2xvciBzaXQgYW1ldCBjb25zZWN0ZXR1ciBhZGlw\r\n" +
          "aXNjaW5nIGVsaXQgcGVsbGVudGVzcXVlIGhhYml0YW50LiBFZ2VzdGFzIGNvbmd1ZSBxdWlzcXVl\r\n" +
          "IGVnZXN0YXMgZGlhbSBpbiBhcmN1IGN1cnN1cyBldWlzbW9kLiBMaWJlcm8gbnVuYyBjb25zZXF1\r\n" +
          "YXQgaW50ZXJkdW0gdmFyaXVzIHNpdCBhbWV0LiBMZW8gdmVsIG9yY2kgcG9ydGEgbm9uIHB1bHZp\r\n" +
          "bmFyIG5lcXVlLiBOaWJoIHByYWVzZW50IHRyaXN0aXF1ZSBtYWduYSBzaXQgYW1ldC4gRnVzY2Ug\r\n" +
          "aWQgdmVsaXQgdXQgdG9ydG9yIHByZXRpdW0uIFNlbXBlciByaXN1cyBpbiBoZW5kcmVyaXQgZ3Jh\r\n" +
          "dmlkYSBydXRydW0uIEVsZW1lbnR1bSBldSBmYWNpbGlzaXMgc2VkIG9kaW8gbW9yYmkgcXVpcy4g\r\n" +
          "VXJuYSBtb2xlc3RpZSBhdCBlbGVtZW50dW0gZXUgZmFjaWxpc2lzIHNlZC4gUHVsdmluYXIgcHJv\r\n" +
          "aW4gZ3JhdmlkYSBoZW5kcmVyaXQgbGVjdHVzIGEuIE5pYmggbWF1cmlzIGN1cnN1cyBtYXR0aXMg\r\n" +
          "bW9sZXN0aWUgYSBpYWN1bGlzLgoKVXQgZW5pbSBibGFuZGl0IHZvbHV0cGF0IG1hZWNlbmFzIHZv\r\n" +
          "bHV0cGF0IGJsYW5kaXQgYWxpcXVhbSBldGlhbS4gQW1ldCBkaWN0dW0gc2l0IGFtZXQganVzdG8g\r\n" +
          "ZG9uZWMgZW5pbSBkaWFtIHZ1bHB1dGF0ZSB1dC4gVWx0cmljZXMgbmVxdWUgb3JuYXJlIGFlbmVh\r\n" +
          "biBldWlzbW9kIGVsZW1lbnR1bSBuaXNpIHF1aXMgZWxlaWZlbmQuIE1pIHByb2luIHNlZCBsaWJl\r\n" +
          "cm8gZW5pbSBzZWQgZmF1Y2lidXMgdHVycGlzIGluLiBFZ2VzdGFzIHB1cnVzIHZpdmVycmEgYWNj\r\n" +
          "dW1zYW4gaW4uIE1hZWNlbmFzIHBoYXJldHJhIGNvbnZhbGxpcyBwb3N1ZXJlIG1vcmJpIGxlby4g\r\n" +
          "Q29uZGltZW50dW0gdml0YWUgc2FwaWVuIHBlbGxlbnRlc3F1ZSBoYWJpdGFudCBtb3JiaSB0cmlz\r\n" +
          "dGlxdWUgc2VuZWN0dXMuIEFjIGF1Y3RvciBhdWd1ZSBtYXVyaXMgYXVndWUgbmVxdWUgZ3Jhdmlk\r\n" +
          "YSBpbiBmZXJtZW50dW0gZXQuIEVnZXQgZXN0IGxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0LiBN\r\n" +
          "YXVyaXMgcmhvbmN1cyBhZW5lYW4gdmVsIGVsaXQgc2NlbGVyaXNxdWUgbWF1cmlzIHBlbGxlbnRl\r\n" +
          "c3F1ZSBwdWx2aW5hci4gVml0YWUgcHVydXMgZmF1Y2lidXMgb3JuYXJlIHN1c3BlbmRpc3NlIHNl\r\n" +
          "ZCBuaXNpIGxhY3VzIHNlZCB2aXZlcnJhLiBBZW5lYW4gdmVsIGVsaXQgc2NlbGVyaXNxdWUgbWF1\r\n" +
          "cmlzIHBlbGxlbnRlc3F1ZS4gSW4gb3JuYXJlIHF1YW0gdml2ZXJyYSBvcmNpIHNhZ2l0dGlzIGV1\r\n" +
          "IHZvbHV0cGF0IG9kaW8gZmFjaWxpc2lzLiBOb24gY3VyYWJpdHVyIGdyYXZpZGEgYXJjdSBhYyB0\r\n" +
          "b3J0b3IuIE1pIHRlbXB1cyBpbXBlcmRpZXQgbnVsbGEgbWFsZXN1YWRhIHBlbGxlbnRlc3F1ZS4g\r\n" +
          "UGFydHVyaWVudCBtb250ZXMgbmFzY2V0dXIgcmlkaWN1bHVzIG11cyBtYXVyaXMgdml0YWUgdWx0\r\n" +
          "cmljaWVzIGxlbyBpbnRlZ2VyLiBOdWxsYSBwb3N1ZXJlIHNvbGxpY2l0dWRpbiBhbGlxdWFtIHVs\r\n" +
          "dHJpY2VzIHNhZ2l0dGlzIG9yY2kuIE9yY2kgcGhhc2VsbHVzIGVnZXN0YXMgdGVsbHVzIHJ1dHJ1\r\n" +
          "bSB0ZWxsdXMuCgpFbmltIHNlZCBmYXVjaWJ1cyB0dXJwaXMgaW4uIEFsaXF1YW0gZmF1Y2lidXMg\r\n" +
          "cHVydXMgaW4gbWFzc2EuIENvbnNlY3RldHVyIGxvcmVtIGRvbmVjIG1hc3NhIHNhcGllbiBmYXVj\r\n" +
          "aWJ1cyBldCBtb2xlc3RpZSBhYyBmZXVnaWF0LiBUb3J0b3Igdml0YWUgcHVydXMgZmF1Y2lidXMg\r\n" +
          "b3JuYXJlIHN1c3BlbmRpc3NlIHNlZC4gT3JuYXJlIHF1YW0gdml2ZXJyYSBvcmNpIHNhZ2l0dGlz\r\n" +
          "IGV1IHZvbHV0cGF0LiBDb25zZWN0ZXR1ciBwdXJ1cyB1dCBmYXVjaWJ1cyBwdWx2aW5hci4gQ29u\r\n" +
          "ZGltZW50dW0gaWQgdmVuZW5hdGlzIGEgY29uZGltZW50dW0gdml0YWUgc2FwaWVuIHBlbGxlbnRl\r\n" +
          "c3F1ZS4gRG9uZWMgcHJldGl1bSB2dWxwdXRhdGUgc2FwaWVuIG5lYyBzYWdpdHRpcyBhbGlxdWFt\r\n" +
          "IG1hbGVzdWFkYSBiaWJlbmR1bS4gRHVpIG51bmMgbWF0dGlzIGVuaW0gdXQgdGVsbHVzIGVsZW1l\r\n" +
          "bnR1bS4gTmVjIGZldWdpYXQgbmlzbCBwcmV0aXVtIGZ1c2NlLiBEYXBpYnVzIHVsdHJpY2VzIGlu\r\n" +
          "IGlhY3VsaXMgbnVuYyBzZWQuIEVnZXQgbnVsbGFtIG5vbiBuaXNpIGVzdCBzaXQgYW1ldCBmYWNp\r\n" +
          "bGlzaXMgbWFnbmEuIFN1c3BlbmRpc3NlIGluIGVzdCBhbnRlIGluIG5pYmguIEdyYXZpZGEgZGlj\r\n" +
          "dHVtIGZ1c2NlIHV0IHBsYWNlcmF0IG9yY2kgbnVsbGEgcGVsbGVudGVzcXVlLiBBbWV0IGVzdCBw\r\n" +
          "bGFjZXJhdCBpbiBlZ2VzdGFzIGVyYXQgaW1wZXJkaWV0LiBBZGlwaXNjaW5nIGVsaXQgcGVsbGVu\r\n" +
          "dGVzcXVlIGhhYml0YW50IG1vcmJpIHRyaXN0aXF1ZSBzZW5lY3R1cyBldC4gVWx0cmljaWVzIG1p\r\n" +
          "IGVnZXQgbWF1cmlzIHBoYXJldHJhIGV0IHVsdHJpY2VzIG5lcXVlIG9ybmFyZSBhZW5lYW4uIEZh\r\n" +
          "Y2lsaXNpcyB2b2x1dHBhdCBlc3QgdmVsaXQgZWdlc3Rhcy4gTWFzc2Egc2VkIGVsZW1lbnR1bSB0\r\n" +
          "ZW1wdXMgZWdlc3RhcyBzZWQuCgpVcm5hIG1vbGVzdGllIGF0IGVsZW1lbnR1bSBldSBmYWNpbGlz\r\n" +
          "aXMgc2VkLiBNYXVyaXMgc2l0IGFtZXQgbWFzc2Egdml0YWUuIFF1YW0gdnVscHV0YXRlIGRpZ25p\r\n" +
          "c3NpbSBzdXNwZW5kaXNzZSBpbiBlc3QgYW50ZSBpbiBuaWJoIG1hdXJpcy4gTWFnbmEgc2l0IGFt\r\n" +
          "ZXQgcHVydXMgZ3JhdmlkYSBxdWlzIGJsYW5kaXQgdHVycGlzIGN1cnN1cyBpbi4gTW9yYmkgbm9u\r\n" +
          "IGFyY3UgcmlzdXMgcXVpcy4gQXVndWUgbGFjdXMgdml2ZXJyYSB2aXRhZSBjb25ndWUgZXUgY29u\r\n" +
          "c2VxdWF0LiBOaWJoIHByYWVzZW50IHRyaXN0aXF1ZSBtYWduYSBzaXQgYW1ldCBwdXJ1cyBncmF2\r\n" +
          "aWRhIHF1aXMuIERpYW0gc2l0IGFtZXQgbmlzbCBzdXNjaXBpdCBhZGlwaXNjaW5nIGJpYmVuZHVt\r\n" +
          "IGVzdC4gRGlnbmlzc2ltIGRpYW0gcXVpcyBlbmltIGxvYm9ydGlzIHNjZWxlcmlzcXVlIGZlcm1l\r\n" +
          "bnR1bS4gRG9uZWMgbWFzc2Egc2FwaWVuIGZhdWNpYnVzIGV0IG1vbGVzdGllIGFjIGZldWdpYXQg\r\n" +
          "c2VkLiBJZCBuZXF1ZSBhbGlxdWFtIHZlc3RpYnVsdW0gbW9yYmkgYmxhbmRpdCBjdXJzdXMgcmlz\r\n" +
          "dXMgYXQuIFZpdGFlIHRvcnRvciBjb25kaW1lbnR1bSBsYWNpbmlhIHF1aXMgdmVsLiBQZWxsZW50\r\n" +
          "ZXNxdWUgYWRpcGlzY2luZyBjb21tb2RvIGVsaXQgYXQgaW1wZXJkaWV0IGR1aS4KClZpdmVycmEg\r\n" +
          "c3VzcGVuZGlzc2UgcG90ZW50aSBudWxsYW0gYWMgdG9ydG9yIHZpdGFlIHB1cnVzLiBBbWV0IHBv\r\n" +
          "cnR0aXRvciBlZ2V0IGRvbG9yIG1vcmJpIG5vbiBhcmN1LiBGZWxpcyBlZ2V0IG51bmMgbG9ib3J0\r\n" +
          "aXMgbWF0dGlzIGFsaXF1YW0gZmF1Y2lidXMgcHVydXMgaW4gbWFzc2EuIFZlc3RpYnVsdW0gbG9y\r\n" +
          "ZW0gc2VkIHJpc3VzIHVsdHJpY2llcyB0cmlzdGlxdWUuIFBsYWNlcmF0IG9yY2kgbnVsbGEgcGVs\r\n" +
          "bGVudGVzcXVlIGRpZ25pc3NpbSBlbmltIHNpdCBhbWV0IHZlbmVuYXRpcy4gTmlzaSBwb3J0YSBs\r\n" +
          "b3JlbSBtb2xsaXMgYWxpcXVhbS4gU2VkIGFyY3Ugbm9uIG9kaW8gZXVpc21vZC4gU2NlbGVyaXNx\r\n" +
          "dWUgZXUgdWx0cmljZXMgdml0YWUgYXVjdG9yLiBBbGlxdWV0IGVuaW0gdG9ydG9yIGF0IGF1Y3Rv\r\n" +
          "ciB1cm5hIG51bmMgaWQuIExhY3VzIHZlc3RpYnVsdW0gc2VkIGFyY3Ugbm9uIG9kaW8uIFZlbCBw\r\n" +
          "aGFyZXRyYSB2ZWwgdHVycGlzIG51bmMgZWdldCBsb3JlbS4gQ29tbW9kbyBlbGl0IGF0IGltcGVy\r\n" +
          "ZGlldCBkdWkgYWNjdW1zYW4gc2l0IGFtZXQgbnVsbGEuCgpPZGlvIHBlbGxlbnRlc3F1ZSBkaWFt\r\n" +
          "IHZvbHV0cGF0IGNvbW1vZG8uIExlY3R1cyBudWxsYSBhdCB2b2x1dHBhdCBkaWFtIHV0IHZlbmVu\r\n" +
          "YXRpcy4gQWVuZWFuIGV1aXNtb2QgZWxlbWVudHVtIG5pc2kgcXVpcyBlbGVpZmVuZCBxdWFtIGFk\r\n" +
          "aXBpc2Npbmcgdml0YWUgcHJvaW4uIE1ldHVzIGRpY3R1bSBhdCB0ZW1wb3IgY29tbW9kbyB1bGxh\r\n" +
          "bWNvcnBlciBhIGxhY3VzLiBUdXJwaXMgbWFzc2EgdGluY2lkdW50IGR1aSB1dCBvcm5hcmUgbGVj\r\n" +
          "dHVzIHNpdCBhbWV0LiBTdXNjaXBpdCB0ZWxsdXMgbWF1cmlzIGEgZGlhbSBtYWVjZW5hcy4gVHVy\r\n" +
          "cGlzIHRpbmNpZHVudCBpZCBhbGlxdWV0IHJpc3VzIGZldWdpYXQuIEZhdWNpYnVzIHR1cnBpcyBp\r\n" +
          "biBldSBtaS4gVGVsbHVzIGVsZW1lbnR1bSBzYWdpdHRpcyB2aXRhZSBldCBsZW8gZHVpcyB1dCBk\r\n" +
          "aWFtLiBFdSBtaSBiaWJlbmR1bSBuZXF1ZSBlZ2VzdGFzIGNvbmd1ZSBxdWlzcXVlIGVnZXN0YXMg\r\n" +
          "ZGlhbSBpbi4gVXQgc2VtIG51bGxhIHBoYXJldHJhIGRpYW0gc2l0LiBQcmFlc2VudCBlbGVtZW50\r\n" +
          "dW0gZmFjaWxpc2lzIGxlbyB2ZWwgZnJpbmdpbGxhLiBCbGFuZGl0IG1hc3NhIGVuaW0gbmVjIGR1\r\n" +
          "aSBudW5jIG1hdHRpcyBlbmltLiBTZWQgZW5pbSB1dCBzZW0gdml2ZXJyYSBhbGlxdWV0IGVnZXQu\r\n" +
          "CgpQaGFyZXRyYSBtYXNzYSBtYXNzYSB1bHRyaWNpZXMgbWkgcXVpcyBoZW5kcmVyaXQgZG9sb3Iu\r\n" +
          "IE51bGxhbSBhYyB0b3J0b3Igdml0YWUgcHVydXMgZmF1Y2lidXMuIExvYm9ydGlzIGVsZW1lbnR1\r\n" +
          "bSBuaWJoIHRlbGx1cyBtb2xlc3RpZSBudW5jIG5vbi4gU2VuZWN0dXMgZXQgbmV0dXMgZXQgbWFs\r\n" +
          "ZXN1YWRhIGZhbWVzLiBSaG9uY3VzIGVzdCBwZWxsZW50ZXNxdWUgZWxpdCB1bGxhbWNvcnBlciBk\r\n" +
          "aWduaXNzaW0gY3JhcyB0aW5jaWR1bnQgbG9ib3J0aXMgZmV1Z2lhdC4gSXBzdW0gYSBhcmN1IGN1\r\n" +
          "cnN1cyB2aXRhZS4gQWMgZmV1Z2lhdCBzZWQgbGVjdHVzIHZlc3RpYnVsdW0gbWF0dGlzLiBBbGlx\r\n" +
          "dWV0IG5lYyB1bGxhbWNvcnBlciBzaXQgYW1ldCByaXN1cyBudWxsYW0uIEVnZXN0YXMgZnJpbmdp\r\n" +
          "bGxhIHBoYXNlbGx1cyBmYXVjaWJ1cyBzY2VsZXJpc3F1ZS4gRXVpc21vZCBlbGVtZW50dW0gbmlz\r\n" +
          "aSBxdWlzIGVsZWlmZW5kIHF1YW0gYWRpcGlzY2luZyB2aXRhZSBwcm9pbi4gU2NlbGVyaXNxdWUg\r\n" +
          "ZmVybWVudHVtIGR1aSBmYXVjaWJ1cyBpbiBvcm5hcmUgcXVhbSB2aXZlcnJhIG9yY2kuIFZpdmVy\r\n" +
          "cmEgYWNjdW1zYW4gaW4gbmlzbCBuaXNpIHNjZWxlcmlzcXVlIGV1LgoKRmF1Y2lidXMgdHVycGlz\r\n" +
          "IGluIGV1IG1pIGJpYmVuZHVtLiBTZWQgZWdlc3RhcyBlZ2VzdGFzIGZyaW5naWxsYSBwaGFzZWxs\r\n" +
          "dXMgZmF1Y2lidXMuIExlY3R1cyBtYXVyaXMgdWx0cmljZXMgZXJvcyBpbiBjdXJzdXMgdHVycGlz\r\n" +
          "IG1hc3NhLiBNYXVyaXMgdWx0cmljZXMgZXJvcyBpbiBjdXJzdXMgdHVycGlzIG1hc3NhIHRpbmNp\r\n" +
          "ZHVudCBkdWkuIEFyY3UgY3Vyc3VzIHZpdGFlIGNvbmd1ZSBtYXVyaXMgcmhvbmN1cyBhZW5lYW4u\r\n" +
          "IEVsZW1lbnR1bSBmYWNpbGlzaXMgbGVvIHZlbCBmcmluZ2lsbGEgZXN0IHVsbGFtY29ycGVyLiBV\r\n" +
          "dCBwaGFyZXRyYSBzaXQgYW1ldCBhbGlxdWFtLiBQdWx2aW5hciBwZWxsZW50ZXNxdWUgaGFiaXRh\r\n" +
          "bnQgbW9yYmkgdHJpc3RpcXVlLiBSaXN1cyBmZXVnaWF0IGluIGFudGUgbWV0dXMuIFZhcml1cyBt\r\n" +
          "b3JiaSBlbmltIG51bmMgZmF1Y2lidXMgYS4gU29sbGljaXR1ZGluIGFjIG9yY2kgcGhhc2VsbHVz\r\n" +
          "IGVnZXN0YXMgdGVsbHVzIHJ1dHJ1bSB0ZWxsdXMgcGVsbGVudGVzcXVlLiBPZGlvIHV0IHNlbSBu\r\n" +
          "dWxsYSBwaGFyZXRyYSBkaWFtIHNpdCBhbWV0IG5pc2wuIExhY2luaWEgYXQgcXVpcyByaXN1cyBz\r\n" +
          "ZWQgdnVscHV0YXRlIG9kaW8gdXQuIExpYmVybyBudW5jIGNvbnNlcXVhdCBpbnRlcmR1bSB2YXJp\r\n" +
          "dXMgc2l0IGFtZXQgbWF0dGlzLiBWZWwgb3JjaSBwb3J0YSBub24gcHVsdmluYXIgbmVxdWUgbGFv\r\n" +
          "cmVldC4KClVsbGFtY29ycGVyIG1vcmJpIHRpbmNpZHVudCBvcm5hcmUgbWFzc2EgZWdldCBlZ2Vz\r\n" +
          "dGFzIHB1cnVzIHZpdmVycmEgYWNjdW1zYW4uIEFkaXBpc2NpbmcgdHJpc3RpcXVlIHJpc3VzIG5l\r\n" +
          "YyBmZXVnaWF0LiBBYyB0dXJwaXMgZWdlc3RhcyBzZWQgdGVtcHVzIHVybmEgZXQuIEV0IG1hbGVz\r\n" +
          "dWFkYSBmYW1lcyBhYyB0dXJwaXMgZWdlc3Rhcy4gUHJldGl1bSBhZW5lYW4gcGhhcmV0cmEgbWFn\r\n" +
          "bmEgYWMgcGxhY2VyYXQgdmVzdGlidWx1bS4gTWFlY2VuYXMgYWNjdW1zYW4gbGFjdXMgdmVsIGZh\r\n" +
          "Y2lsaXNpcyB2b2x1dHBhdCBlc3QgdmVsaXQuIFBoYXJldHJhIGV0IHVsdHJpY2VzIG5lcXVlIG9y\r\n" +
          "bmFyZSBhZW5lYW4gZXVpc21vZCBlbGVtZW50dW0gbmlzaSBxdWlzLiBWb2x1dHBhdCBjb21tb2Rv\r\n" +
          "IHNlZCBlZ2VzdGFzIGVnZXN0YXMgZnJpbmdpbGxhLiBQcmV0aXVtIHF1YW0gdnVscHV0YXRlIGRp\r\n" +
          "Z25pc3NpbSBzdXNwZW5kaXNzZSBpbiBlc3QgYW50ZSBpbiBuaWJoLiBUZW1wdXMgZWdlc3RhcyBz\r\n" +
          "ZWQgc2VkIHJpc3VzLgoKVmFyaXVzIGR1aXMgYXQgY29uc2VjdGV0dXIgbG9yZW0gZG9uZWMuIFNv\r\n" +
          "bGxpY2l0dWRpbiBhbGlxdWFtIHVsdHJpY2VzIHNhZ2l0dGlzIG9yY2kgYSBzY2VsZXJpc3F1ZSBw\r\n" +
          "dXJ1cyBzZW1wZXIgZWdldC4gTGVjdHVzIHVybmEgZHVpcyBjb252YWxsaXMgY29udmFsbGlzIHRl\r\n" +
          "bGx1cyBpZCBpbnRlcmR1bS4gSWFjdWxpcyBudW5jIHNlZCBhdWd1ZSBsYWN1cyB2aXZlcnJhIHZp\r\n" +
          "dGFlIGNvbmd1ZSBldSBjb25zZXF1YXQuIEFjY3Vtc2FuIGxhY3VzIHZlbCBmYWNpbGlzaXMgdm9s\r\n" +
          "dXRwYXQgZXN0IHZlbGl0LiBTZWQgaWQgc2VtcGVyIHJpc3VzIGluLiBQcm9pbiBmZXJtZW50dW0g\r\n" +
          "bGVvIHZlbCBvcmNpIHBvcnRhIG5vbiBwdWx2aW5hci4gTWkgaXBzdW0gZmF1Y2lidXMgdml0YWUg\r\n" +
          "YWxpcXVldCBuZWMgdWxsYW1jb3JwZXIgc2l0IGFtZXQgcmlzdXMuIFNlZCBhcmN1IG5vbiBvZGlv\r\n" +
          "IGV1aXNtb2QgbGFjaW5pYSBhdCBxdWlzIHJpc3VzIHNlZC4gSW4gbW9sbGlzIG51bmMgc2VkIGlk\r\n" +
          "LiBUcmlzdGlxdWUgcmlzdXMgbmVjIGZldWdpYXQgaW4gZmVybWVudHVtLiBNYXNzYSBwbGFjZXJh\r\n" +
          "dCBkdWlzIHVsdHJpY2llcyBsYWN1cyBzZWQgdHVycGlzIHRpbmNpZHVudCBpZCBhbGlxdWV0LiBF\r\n" +
          "dCBzb2xsaWNpdHVkaW4gYWMgb3JjaSBwaGFzZWxsdXMgZWdlc3RhcyB0ZWxsdXMgcnV0cnVtIHRl\r\n" +
          "bGx1cy4gQWxpcXVhbSB1bHRyaWNlcyBzYWdpdHRpcyBvcmNpIGEgc2NlbGVyaXNxdWUgcHVydXMg\r\n" +
          "c2VtcGVyLgoKUG9ydGEgbm9uIHB1bHZpbmFyIG5lcXVlIGxhb3JlZXQgc3VzcGVuZGlzc2UgaW50\r\n" +
          "ZXJkdW0gY29uc2VjdGV0dXIgbGliZXJvLiBQcmV0aXVtIG5pYmggaXBzdW0gY29uc2VxdWF0IG5p\r\n" +
          "c2wuIEhhYml0YXNzZSBwbGF0ZWEgZGljdHVtc3QgcXVpc3F1ZSBzYWdpdHRpcyBwdXJ1cyBzaXQg\r\n" +
          "YW1ldCB2b2x1dHBhdCBjb25zZXF1YXQuIE51bmMgc2VkIGF1Z3VlIGxhY3VzIHZpdmVycmEgdml0\r\n" +
          "YWUgY29uZ3VlIGV1IGNvbnNlcXVhdC4gRGljdHVtIG5vbiBjb25zZWN0ZXR1ciBhIGVyYXQgbmFt\r\n" +
          "LiBUdXJwaXMgZWdlc3RhcyBtYWVjZW5hcyBwaGFyZXRyYSBjb252YWxsaXMgcG9zdWVyZS4gRHVp\r\n" +
          "cyBjb252YWxsaXMgY29udmFsbGlzIHRlbGx1cyBpZCBpbnRlcmR1bSB2ZWxpdCBsYW9yZWV0LiBM\r\n" +
          "b3JlbSBzZWQgcmlzdXMgdWx0cmljaWVzIHRyaXN0aXF1ZSBudWxsYSBhbGlxdWV0IGVuaW0gdG9y\r\n" +
          "dG9yLiBQbGFjZXJhdCBvcmNpIG51bGxhIHBlbGxlbnRlc3F1ZSBkaWduaXNzaW0gZW5pbSBzaXQg\r\n" +
          "YW1ldCB2ZW5lbmF0aXMgdXJuYS4gU2FnaXR0aXMgdml0YWUgZXQgbGVvIGR1aXMgdXQuIFZ1bHB1\r\n" +
          "dGF0ZSB1dCBwaGFyZXRyYSBzaXQgYW1ldCBhbGlxdWFtIGlkIGRpYW0uIE1hbGVzdWFkYSBwZWxs\r\n" +
          "ZW50ZXNxdWUgZWxpdCBlZ2V0IGdyYXZpZGEgY3VtIHNvY2lpcyBuYXRvcXVlIHBlbmF0aWJ1cy4g\r\n" +
          "U2NlbGVyaXNxdWUgcHVydXMgc2VtcGVyIGVnZXQgZHVpcyBhdCB0ZWxsdXMuIFV0IGNvbnNlcXVh\r\n" +
          "dCBzZW1wZXIgdml2ZXJyYSBuYW0uIFRpbmNpZHVudCBvcm5hcmUgbWFzc2EgZWdldCBlZ2VzdGFz\r\n" +
          "LiBBZGlwaXNjaW5nIGVsaXQgdXQgYWxpcXVhbSBwdXJ1cyBzaXQgYW1ldCBsdWN0dXMuIERvbG9y\r\n" +
          "IHB1cnVzIG5vbiBlbmltIHByYWVzZW50IGVsZW1lbnR1bS4gVml0YWUgdGVtcHVzIHF1YW0gcGVs\r\n" +
          "bGVudGVzcXVlIG5lYyBuYW0gYWxpcXVhbSBzZW0gZXQgdG9ydG9yLiBIYWJpdGFzc2UgcGxhdGVh\r\n" +
          "IGRpY3R1bXN0IHZlc3RpYnVsdW0gcmhvbmN1cy4gU2VtIGludGVnZXIgdml0YWUganVzdG8gZWdl\r\n" +
          "dCBtYWduYS4KCk5vbiBibGFuZGl0IG1hc3NhIGVuaW0gbmVjIGR1aSBudW5jLiBWaXRhZSBhbGlx\r\n" +
          "dWV0IG5lYyB1bGxhbWNvcnBlciBzaXQuIExvcmVtIGRvbG9yIHNlZCB2aXZlcnJhIGlwc3VtIG51\r\n" +
          "bmMuIEFtZXQgcG9ydHRpdG9yIGVnZXQgZG9sb3IgbW9yYmkuIEVzdCB1bGxhbWNvcnBlciBlZ2V0\r\n" +
          "IG51bGxhIGZhY2lsaXNpIGV0aWFtIGRpZ25pc3NpbSBkaWFtLiBDb25zZXF1YXQgc2VtcGVyIHZp\r\n" +
          "dmVycmEgbmFtIGxpYmVybyBqdXN0byBsYW9yZWV0IHNpdCBhbWV0IGN1cnN1cy4gVml2YW11cyBh\r\n" +
          "cmN1IGZlbGlzIGJpYmVuZHVtIHV0IHRyaXN0aXF1ZSBldCBlZ2VzdGFzIHF1aXMgaXBzdW0uIEN1\r\n" +
          "cmFiaXR1ciB2aXRhZSBudW5jIHNlZCB2ZWxpdCBkaWduaXNzaW0gc29kYWxlcyB1dC4gUmlzdXMg\r\n" +
          "dWx0cmljaWVzIHRyaXN0aXF1ZSBudWxsYSBhbGlxdWV0IGVuaW0uIFBlbGxlbnRlc3F1ZSBwdWx2\r\n" +
          "aW5hciBwZWxsZW50ZXNxdWUgaGFiaXRhbnQgbW9yYmkgdHJpc3RpcXVlIHNlbmVjdHVzIGV0LiBE\r\n" +
          "dWlzIGF0IGNvbnNlY3RldHVyIGxvcmVtIGRvbmVjIG1hc3NhIHNhcGllbiBmYXVjaWJ1cyBldCBt\r\n" +
          "b2xlc3RpZS4gUHJhZXNlbnQgdHJpc3RpcXVlIG1hZ25hIHNpdCBhbWV0IHB1cnVzIGdyYXZpZGEg\r\n" +
          "cXVpcy4gTWF1cmlzIHJob25jdXMgYWVuZWFuIHZlbCBlbGl0IHNjZWxlcmlzcXVlLiBJZCBhbGlx\r\n" +
          "dWV0IGxlY3R1cyBwcm9pbiBuaWJoIG5pc2wgY29uZGltZW50dW0gaWQgdmVuZW5hdGlzLiBQaGFz\r\n" +
          "ZWxsdXMgZWdlc3RhcyB0ZWxsdXMgcnV0cnVtIHRlbGx1cyBwZWxsZW50ZXNxdWUgZXUuIExvcmVt\r\n" +
          "IGlwc3VtIGRvbG9yIHNpdCBhbWV0IGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdC4KCkEgY3Jh\r\n" +
          "cyBzZW1wZXIgYXVjdG9yIG5lcXVlLiBPcm5hcmUgYXJjdSBvZGlvIHV0IHNlbSBudWxsYSBwaGFy\r\n" +
          "ZXRyYSBkaWFtIHNpdC4gUHJldGl1bSBuaWJoIGlwc3VtIGNvbnNlcXVhdCBuaXNsIHZlbC4gVml2\r\n" +
          "ZXJyYSBuYW0gbGliZXJvIGp1c3RvIGxhb3JlZXQgc2l0IGFtZXQgY3Vyc3VzIHNpdC4gQXJjdSB2\r\n" +
          "aXRhZSBlbGVtZW50dW0gY3VyYWJpdHVyIHZpdGFlIG51bmMgc2VkIHZlbGl0IGRpZ25pc3NpbSBz\r\n" +
          "b2RhbGVzLiBFZ2VzdGFzIGZyaW5naWxsYSBwaGFzZWxsdXMgZmF1Y2lidXMgc2NlbGVyaXNxdWUg\r\n" +
          "ZWxlaWZlbmQgZG9uZWMgcHJldGl1bSB2dWxwdXRhdGUuIExlbyB2ZWwgb3JjaSBwb3J0YSBub24u\r\n" +
          "IER1aSB2aXZhbXVzIGFyY3UgZmVsaXMgYmliZW5kdW0uIE51bGxhIGZhY2lsaXNpIG51bGxhbSB2\r\n" +
          "ZWhpY3VsYSBpcHN1bSBhIGFyY3UgY3Vyc3VzIHZpdGFlIGNvbmd1ZS4gRXQgbW9sZXN0aWUgYWMg\r\n" +
          "ZmV1Z2lhdCBzZWQgbGVjdHVzLiBBbGlxdWFtIGZhdWNpYnVzIHB1cnVzIGluIG1hc3NhIHRlbXBv\r\n" +
          "ciBuZWMgZmV1Z2lhdCBuaXNsLgoKVml0YWUgZXQgbGVvIGR1aXMgdXQgZGlhbSBxdWFtIG51bGxh\r\n" +
          "LiBJZCBpbnRlcmR1bSB2ZWxpdCBsYW9yZWV0IGlkIGRvbmVjIHVsdHJpY2VzIHRpbmNpZHVudCBh\r\n" +
          "cmN1IG5vbi4gRWdldCBudW5jIHNjZWxlcmlzcXVlIHZpdmVycmEgbWF1cmlzIGluIGFsaXF1YW0g\r\n" +
          "c2VtIGZyaW5naWxsYSB1dC4gU2l0IGFtZXQgZmFjaWxpc2lzIG1hZ25hIGV0aWFtIHRlbXBvciBv\r\n" +
          "cmNpLiBPZGlvIGV1IGZldWdpYXQgcHJldGl1bSBuaWJoIGlwc3VtIGNvbnNlcXVhdC4gTmVxdWUg\r\n" +
          "YWxpcXVhbSB2ZXN0aWJ1bHVtIG1vcmJpIGJsYW5kaXQgY3Vyc3VzIHJpc3VzIGF0IHVsdHJpY2Vz\r\n" +
          "IG1pLiBWZXN0aWJ1bHVtIGxlY3R1cyBtYXVyaXMgdWx0cmljZXMgZXJvcyBpbiBjdXJzdXMuIFZl\r\n" +
          "bmVuYXRpcyBhIGNvbmRpbWVudHVtIHZpdGFlIHNhcGllbiBwZWxsZW50ZXNxdWUgaGFiaXRhbnQg\r\n" +
          "bW9yYmkgdHJpc3RpcXVlLiBUcmlzdGlxdWUgbnVsbGEgYWxpcXVldCBlbmltIHRvcnRvciBhdCBh\r\n" +
          "dWN0b3IgdXJuYSBudW5jLiBDb21tb2RvIGVsaXQgYXQgaW1wZXJkaWV0IGR1aSBhY2N1bXNhbi4g\r\n" +
          "SWFjdWxpcyB1cm5hIGlkIHZvbHV0cGF0IGxhY3VzIGxhb3JlZXQgbm9uIGN1cmFiaXR1ci4gUXVp\r\n" +
          "cyBlbGVpZmVuZCBxdWFtIGFkaXBpc2Npbmcgdml0YWUuCgpWaXRhZSBhdWN0b3IgZXUgYXVndWUg\r\n" +
          "dXQgbGVjdHVzIGFyY3UgYmliZW5kdW0uIFBoYXJldHJhIGNvbnZhbGxpcyBwb3N1ZXJlIG1vcmJp\r\n" +
          "IGxlbyB1cm5hLiBWaXRhZSBqdXN0byBlZ2V0IG1hZ25hIGZlcm1lbnR1bSBpYWN1bGlzIGV1IG5v\r\n" +
          "biBkaWFtIHBoYXNlbGx1cy4gRXQgcGhhcmV0cmEgcGhhcmV0cmEgbWFzc2EgbWFzc2EgdWx0cmlj\r\n" +
          "aWVzLiBBbGlxdWFtIHZlc3RpYnVsdW0gbW9yYmkgYmxhbmRpdCBjdXJzdXMuIEV0aWFtIHNpdCBh\r\n" +
          "bWV0IG5pc2wgcHVydXMgaW4uIE51bmMgY29uc2VxdWF0IGludGVyZHVtIHZhcml1cyBzaXQuIERp\r\n" +
          "YW0gc2l0IGFtZXQgbmlzbCBzdXNjaXBpdCBhZGlwaXNjaW5nIGJpYmVuZHVtLiBOdW5jIG1hdHRp\r\n" +
          "cyBlbmltIHV0IHRlbGx1cyBlbGVtZW50dW0uIFF1YW0gbGFjdXMgc3VzcGVuZGlzc2UgZmF1Y2li\r\n" +
          "dXMgaW50ZXJkdW0gcG9zdWVyZSBsb3JlbSBpcHN1bSBkb2xvciBzaXQuIFNlZCBuaXNpIGxhY3Vz\r\n" +
          "IHNlZCB2aXZlcnJhLiBEaWFtIHF1YW0gbnVsbGEgcG9ydHRpdG9yIG1hc3NhIGlkIG5lcXVlIGFs\r\n" +
          "aXF1YW0gdmVzdGlidWx1bS4gRHVpcyBhdCB0ZWxsdXMgYXQgdXJuYSBjb25kaW1lbnR1bSBtYXR0\r\n" +
          "aXMgcGVsbGVudGVzcXVlLgoKVGluY2lkdW50IGVnZXQgbnVsbGFtIG5vbiBuaXNpIGVzdCBzaXQg\r\n" +
          "YW1ldC4gSXBzdW0gbnVuYyBhbGlxdWV0IGJpYmVuZHVtIGVuaW0gZmFjaWxpc2lzIGdyYXZpZGEg\r\n" +
          "bmVxdWUgY29udmFsbGlzLiBGdXNjZSBpZCB2ZWxpdCB1dCB0b3J0b3IuIFNpdCBhbWV0IHB1cnVz\r\n" +
          "IGdyYXZpZGEgcXVpcy4gVXJuYSBuZWMgdGluY2lkdW50IHByYWVzZW50IHNlbXBlci4gVm9sdXRw\r\n" +
          "YXQgY29tbW9kbyBzZWQgZWdlc3RhcyBlZ2VzdGFzIGZyaW5naWxsYSBwaGFzZWxsdXMgZmF1Y2li\r\n" +
          "dXMgc2NlbGVyaXNxdWUgZWxlaWZlbmQuIFRyaXN0aXF1ZSBtYWduYSBzaXQgYW1ldCBwdXJ1cyBn\r\n" +
          "cmF2aWRhIHF1aXMgYmxhbmRpdCB0dXJwaXMuIFV0IHNlbSB2aXZlcnJhIGFsaXF1ZXQgZWdldCBz\r\n" +
          "aXQgYW1ldCB0ZWxsdXMgY3JhcyBhZGlwaXNjaW5nLiBCbGFuZGl0IGxpYmVybyB2b2x1dHBhdCBz\r\n" +
          "ZWQgY3JhcyBvcm5hcmUgYXJjdSBkdWkgdml2YW11cy4gVWxsYW1jb3JwZXIgYSBsYWN1cyB2ZXN0\r\n" +
          "aWJ1bHVtIHNlZCBhcmN1IG5vbiBvZGlvIGV1aXNtb2QuCgpMZW8gdmVsIG9yY2kgcG9ydGEgbm9u\r\n" +
          "LiBFdSBjb25zZXF1YXQgYWMgZmVsaXMgZG9uZWMgZXQuIE5ldHVzIGV0IG1hbGVzdWFkYSBmYW1l\r\n" +
          "cyBhYyB0dXJwaXMgZWdlc3RhcyBzZWQgdGVtcHVzIHVybmEuIEVnZXQgbG9yZW0gZG9sb3Igc2Vk\r\n" +
          "IHZpdmVycmEgaXBzdW0gbnVuYy4gTWFlY2VuYXMgc2VkIGVuaW0gdXQgc2VtIHZpdmVycmEuIFZl\r\n" +
          "bCBvcmNpIHBvcnRhIG5vbiBwdWx2aW5hciBuZXF1ZS4gQXQgdGVtcG9yIGNvbW1vZG8gdWxsYW1j\r\n" +
          "b3JwZXIgYSBsYWN1cyB2ZXN0aWJ1bHVtIHNlZCBhcmN1LiBMb2JvcnRpcyBlbGVtZW50dW0gbmli\r\n" +
          "aCB0ZWxsdXMgbW9sZXN0aWUgbnVuYyBub24uIFBlbGxlbnRlc3F1ZSBuZWMgbmFtIGFsaXF1YW0g\r\n" +
          "c2VtIGV0IHRvcnRvciBjb25zZXF1YXQuIEludGVyZHVtIHZhcml1cyBzaXQgYW1ldCBtYXR0aXMg\r\n" +
          "dnVscHV0YXRlIGVuaW0gbnVsbGEgYWxpcXVldCBwb3J0dGl0b3IuIFR1cnBpcyBlZ2VzdGFzIHBy\r\n" +
          "ZXRpdW0gYWVuZWFuIHBoYXJldHJhLiBJcHN1bSBkb2xvciBzaXQgYW1ldCBjb25zZWN0ZXR1ciBh\r\n" +
          "ZGlwaXNjaW5nIGVsaXQuIFNvbGxpY2l0dWRpbiB0ZW1wb3IgaWQgZXUgbmlzbCBudW5jIG1pLiBU\r\n" +
          "ZWxsdXMgbWF1cmlzIGEgZGlhbSBtYWVjZW5hcyBzZWQgZW5pbSB1dCBzZW0gdml2ZXJyYS4gVXQg\r\n" +
          "bW9yYmkgdGluY2lkdW50IGF1Z3VlIGludGVyZHVtIHZlbGl0IGV1aXNtb2QgaW4gcGVsbGVudGVz\r\n" +
          "cXVlIG1hc3NhLiBUb3J0b3IgYWxpcXVhbSBudWxsYSBmYWNpbGlzaSBjcmFzLiBBZGlwaXNjaW5n\r\n" +
          "IHRyaXN0aXF1ZSByaXN1cyBuZWMgZmV1Z2lhdCBpbiBmZXJtZW50dW0gcG9zdWVyZSB1cm5hLiBM\r\n" +
          "YWN1cyBsYW9yZWV0IG5vbiBjdXJhYml0dXIgZ3JhdmlkYSBhcmN1IGFjIHRvcnRvciBkaWduaXNz\r\n" +
          "aW0gY29udmFsbGlzLiBBdWd1ZSBtYXVyaXMgYXVndWUgbmVxdWUgZ3JhdmlkYSBpbiBmZXJtZW50\r\n" +
          "dW0gZXQuIENvbW1vZG8gdml2ZXJyYSBtYWVjZW5hcyBhY2N1bXNhbiBsYWN1cyB2ZWwgZmFjaWxp\r\n" +
          "c2lzIHZvbHV0cGF0IGVzdC4KCkVsaXQgcGVsbGVudGVzcXVlIGhhYml0YW50IG1vcmJpIHRyaXN0\r\n" +
          "aXF1ZS4gU29sbGljaXR1ZGluIG5pYmggc2l0IGFtZXQgY29tbW9kbyBudWxsYS4gSXBzdW0gZmF1\r\n" +
          "Y2lidXMgdml0YWUgYWxpcXVldCBuZWMgdWxsYW1jb3JwZXIuIEluIG5pYmggbWF1cmlzIGN1cnN1\r\n" +
          "cyBtYXR0aXMgbW9sZXN0aWUgYSBpYWN1bGlzIGF0IGVyYXQuIFZpdGFlIGVsZW1lbnR1bSBjdXJh\r\n" +
          "Yml0dXIgdml0YWUgbnVuYyBzZWQgdmVsaXQuIER1aXMgdWx0cmljaWVzIGxhY3VzIHNlZCB0dXJw\r\n" +
          "aXMgdGluY2lkdW50LiBOaWJoIHZlbmVuYXRpcyBjcmFzIHNlZCBmZWxpcyBlZ2V0IHZlbGl0LiBU\r\n" +
          "ZWxsdXMgYXQgdXJuYSBjb25kaW1lbnR1bSBtYXR0aXMuIEVuaW0gbnVuYyBmYXVjaWJ1cyBhIHBl\r\n" +
          "bGxlbnRlc3F1ZSBzaXQgYW1ldCBwb3J0dGl0b3IgZWdldC4gU2l0IGFtZXQganVzdG8gZG9uZWMg\r\n" +
          "ZW5pbSBkaWFtLiBBYyBwbGFjZXJhdCB2ZXN0aWJ1bHVtIGxlY3R1cyBtYXVyaXMgdWx0cmljZXMg\r\n" +
          "ZXJvcyBpbiBjdXJzdXMuIFNpdCBhbWV0IGVzdCBwbGFjZXJhdCBpbiBlZ2VzdGFzIGVyYXQgaW1w\r\n" +
          "ZXJkaWV0IHNlZC4gRWdldCBudWxsYSBmYWNpbGlzaSBldGlhbSBkaWduaXNzaW0gZGlhbSBxdWlz\r\n" +
          "IGVuaW0gbG9ib3J0aXMgc2NlbGVyaXNxdWUuIEVsaXQgcGVsbGVudGVzcXVlIGhhYml0YW50IG1v\r\n" +
          "cmJpIHRyaXN0aXF1ZSBzZW5lY3R1cyBldCBuZXR1cy4gTGVjdHVzIGFyY3UgYmliZW5kdW0gYXQg\r\n" +
          "dmFyaXVzIHZlbCBwaGFyZXRyYS4gTmFtIGF0IGxlY3R1cyB1cm5hIGR1aXMgY29udmFsbGlzIGNv\r\n" +
          "bnZhbGxpcy4gQ29tbW9kbyBudWxsYSBmYWNpbGlzaSBudWxsYW0gdmVoaWN1bGEgaXBzdW0gYS4g\r\n" +
          "QXJjdSBvZGlvIHV0IHNlbSBudWxsYSBwaGFyZXRyYSBkaWFtIHNpdCBhbWV0IG5pc2wuIEFkaXBp\r\n" +
          "c2NpbmcgY29tbW9kbyBlbGl0IGF0IGltcGVyZGlldCBkdWkgYWNjdW1zYW4gc2l0LiBJbiB2aXRh\r\n" +
          "ZSB0dXJwaXMgbWFzc2Egc2VkIGVsZW1lbnR1bSB0ZW1wdXMgZWdlc3Rhcy4KClF1aXMgYmxhbmRp\r\n" +
          "dCB0dXJwaXMgY3Vyc3VzIGluIGhhYyBoYWJpdGFzc2UgcGxhdGVhIGRpY3R1bXN0IHF1aXNxdWUu\r\n" +
          "IEZlbGlzIGVnZXQgdmVsaXQgYWxpcXVldCBzYWdpdHRpcyBpZCBjb25zZWN0ZXR1ci4gTW9yYmkg\r\n" +
          "dHJpc3RpcXVlIHNlbmVjdHVzIGV0IG5ldHVzLiBOaXNpIHF1aXMgZWxlaWZlbmQgcXVhbSBhZGlw\r\n" +
          "aXNjaW5nLiBBYyBvcmNpIHBoYXNlbGx1cyBlZ2VzdGFzIHRlbGx1cyBydXRydW0gdGVsbHVzIHBl\r\n" +
          "bGxlbnRlc3F1ZS4gRXRpYW0gc2l0IGFtZXQgbmlzbCBwdXJ1cyBpbiBtb2xsaXMuIEFtZXQgdm9s\r\n" +
          "dXRwYXQgY29uc2VxdWF0IG1hdXJpcyBudW5jIGNvbmd1ZSBuaXNpLiBOdW5jIGFsaXF1ZXQgYmli\r\n" +
          "ZW5kdW0gZW5pbSBmYWNpbGlzaXMgZ3JhdmlkYSBuZXF1ZSBjb252YWxsaXMuIFNjZWxlcmlzcXVl\r\n" +
          "IGZlbGlzIGltcGVyZGlldCBwcm9pbiBmZXJtZW50dW0gbGVvLiBWYXJpdXMgcXVhbSBxdWlzcXVl\r\n" +
          "IGlkIGRpYW0gdmVsIHF1YW0gZWxlbWVudHVtIHB1bHZpbmFyIGV0aWFtLiBMb3JlbSBtb2xsaXMg\r\n" +
          "YWxpcXVhbSB1dCBwb3J0dGl0b3IgbGVvIGEgZGlhbSBzb2xsaWNpdHVkaW4uIElwc3VtIGRvbG9y\r\n" +
          "IHNpdCBhbWV0IGNvbnNlY3RldHVyIGFkaXBpc2NpbmcuIE1hdXJpcyBudW5jIGNvbmd1ZSBuaXNp\r\n" +
          "IHZpdGFlIHN1c2NpcGl0LgoKUHVydXMgZ3JhdmlkYSBxdWlzIGJsYW5kaXQgdHVycGlzIGN1cnN1\r\n" +
          "cyBpbi4gQXQgaW4gdGVsbHVzIGludGVnZXIgZmV1Z2lhdCBzY2VsZXJpc3F1ZS4gUmhvbmN1cyB1\r\n" +
          "cm5hIG5lcXVlIHZpdmVycmEganVzdG8gbmVjIHVsdHJpY2VzIGR1aS4gTW9yYmkgdHJpc3RpcXVl\r\n" +
          "IHNlbmVjdHVzIGV0IG5ldHVzIGV0IG1hbGVzdWFkYSBmYW1lcyBhYy4gQXQgbGVjdHVzIHVybmEg\r\n" +
          "ZHVpcyBjb252YWxsaXMuIE1pIGJpYmVuZHVtIG5lcXVlIGVnZXN0YXMgY29uZ3VlIHF1aXNxdWUg\r\n" +
          "ZWdlc3RhcyBkaWFtLiBWb2x1dHBhdCBkaWFtIHV0IHZlbmVuYXRpcyB0ZWxsdXMgaW4gbWV0dXMg\r\n" +
          "dnVscHV0YXRlIGV1IHNjZWxlcmlzcXVlLiBQdXJ1cyBzZW1wZXIgZWdldCBkdWlzIGF0IHRlbGx1\r\n" +
          "cyBhdCB1cm5hIGNvbmRpbWVudHVtIG1hdHRpcy4gTmF0b3F1ZSBwZW5hdGlidXMgZXQgbWFnbmlz\r\n" +
          "IGRpcyBwYXJ0dXJpZW50IG1vbnRlcyBuYXNjZXR1ciByaWRpY3VsdXMuIE51bGxhIGZhY2lsaXNp\r\n" +
          "IGV0aWFtIGRpZ25pc3NpbSBkaWFtLiBFbGVtZW50dW0gc2FnaXR0aXMgdml0YWUgZXQgbGVvIGR1\r\n" +
          "aXMgdXQgZGlhbS4gRmF1Y2lidXMgc2NlbGVyaXNxdWUgZWxlaWZlbmQgZG9uZWMgcHJldGl1bSB2\r\n" +
          "dWxwdXRhdGUgc2FwaWVuIG5lYyBzYWdpdHRpcy4gTG9ib3J0aXMgZWxlbWVudHVtIG5pYmggdGVs\r\n" +
          "bHVzIG1vbGVzdGllLiBDcmFzIHRpbmNpZHVudCBsb2JvcnRpcyBmZXVnaWF0IHZpdmFtdXMgYXQg\r\n" +
          "YXVndWUgZWdldCBhcmN1LiBGYW1lcyBhYyB0dXJwaXMgZWdlc3RhcyBpbnRlZ2VyIGVnZXQgYWxp\r\n" +
          "cXVldCBuaWJoIHByYWVzZW50LiBTYWdpdHRpcyB2aXRhZSBldCBsZW8gZHVpcyB1dCBkaWFtLiBW\r\n" +
          "aXZlcnJhIG1hdXJpcyBpbiBhbGlxdWFtIHNlbSBmcmluZ2lsbGEgdXQgbW9yYmkgdGluY2lkdW50\r\n" +
          "IGF1Z3VlLiBEb25lYyBhYyBvZGlvIHRlbXBvciBvcmNpIGRhcGlidXMgdWx0cmljZXMgaW4gaWFj\r\n" +
          "dWxpcy4gRmF1Y2lidXMgYSBwZWxsZW50ZXNxdWUgc2l0IGFtZXQgcG9ydHRpdG9yLiBTZW0gZXQg\r\n" +
          "dG9ydG9yIGNvbnNlcXVhdCBpZCBwb3J0YSBuaWJoIHZlbmVuYXRpcyBjcmFzIHNlZC4KCkxvcmVt\r\n" +
          "IGlwc3VtIGRvbG9yIHNpdCBhbWV0IGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdCBwZWxsZW50\r\n" +
          "ZXNxdWUuIEVzdCBhbnRlIGluIG5pYmggbWF1cmlzIGN1cnN1cyBtYXR0aXMgbW9sZXN0aWUgYSBp\r\n" +
          "YWN1bGlzLiBFdCBtYWxlc3VhZGEgZmFtZXMgYWMgdHVycGlzIGVnZXN0YXMgc2VkIHRlbXB1cyB1\r\n" +
          "cm5hLiBTYWdpdHRpcyBwdXJ1cyBzaXQgYW1ldCB2b2x1dHBhdC4gUGVsbGVudGVzcXVlIGVsaXQg\r\n" +
          "dWxsYW1jb3JwZXIgZGlnbmlzc2ltIGNyYXMgdGluY2lkdW50IGxvYm9ydGlzIGZldWdpYXQgdml2\r\n" +
          "YW11cyBhdC4gUHJvaW4gZmVybWVudHVtIGxlbyB2ZWwgb3JjaSBwb3J0YSBub24uIEFsaXF1YW0g\r\n" +
          "ZXRpYW0gZXJhdCB2ZWxpdCBzY2VsZXJpc3F1ZS4gQ29udmFsbGlzIGEgY3JhcyBzZW1wZXIgYXVj\r\n" +
          "dG9yLiBDcmFzIGZlcm1lbnR1bSBvZGlvIGV1IGZldWdpYXQgcHJldGl1bSBuaWJoIGlwc3VtLiBM\r\n" +
          "YWN1cyBzZWQgdml2ZXJyYSB0ZWxsdXMgaW4gaGFjIGhhYml0YXNzZS4gQW1ldCByaXN1cyBudWxs\r\n" +
          "YW0gZWdldCBmZWxpcyBlZ2V0IG51bmMgbG9ib3J0aXMuIE1hZ25pcyBkaXMgcGFydHVyaWVudCBt\r\n" +
          "b250ZXMgbmFzY2V0dXIgcmlkaWN1bHVzIG11cyBtYXVyaXMuIFRvcnRvciB2aXRhZSBwdXJ1cyBm\r\n" +
          "YXVjaWJ1cyBvcm5hcmUgc3VzcGVuZGlzc2UuIEp1c3RvIGxhb3JlZXQgc2l0IGFtZXQgY3Vyc3Vz\r\n" +
          "IHNpdCBhbWV0IGRpY3R1bSBzaXQgYW1ldC4gTmFtIGFsaXF1YW0gc2VtIGV0IHRvcnRvciBjb25z\r\n" +
          "ZXF1YXQgaWQgcG9ydGEuCgpWaXRhZSBwcm9pbiBzYWdpdHRpcyBuaXNsIHJob25jdXMgbWF0dGlz\r\n" +
          "IHJob25jdXMuIFRlbXBvciBuZWMgZmV1Z2lhdCBuaXNsIHByZXRpdW0gZnVzY2UuIE5lcXVlIHNv\r\n" +
          "ZGFsZXMgdXQgZXRpYW0gc2l0LiBRdWlzIHZlbCBlcm9zIGRvbmVjIGFjIG9kaW8uIEhhYml0YW50\r\n" +
          "IG1vcmJpIHRyaXN0aXF1ZSBzZW5lY3R1cyBldC4gTWV0dXMgdnVscHV0YXRlIGV1IHNjZWxlcmlz\r\n" +
          "cXVlIGZlbGlzLiBFZ2V0IHNpdCBhbWV0IHRlbGx1cyBjcmFzIGFkaXBpc2NpbmcgZW5pbSBldSB0\r\n" +
          "dXJwaXMuIEV1aXNtb2QgaW4gcGVsbGVudGVzcXVlIG1hc3NhIHBsYWNlcmF0IGR1aXMgdWx0cmlj\r\n" +
          "aWVzIGxhY3VzIHNlZCB0dXJwaXMuIFNhZ2l0dGlzIGFsaXF1YW0gbWFsZXN1YWRhIGJpYmVuZHVt\r\n" +
          "IGFyY3UuIFNlZCBhcmN1IG5vbiBvZGlvIGV1aXNtb2QgbGFjaW5pYSBhdCBxdWlzLiBHcmF2aWRh\r\n" +
          "IG5lcXVlIGNvbnZhbGxpcyBhIGNyYXMgc2VtcGVyIGF1Y3RvciBuZXF1ZSB2aXRhZSB0ZW1wdXMu\r\n" +
          "IEFtZXQganVzdG8gZG9uZWMgZW5pbSBkaWFtIHZ1bHB1dGF0ZSB1dCBwaGFyZXRyYS4gRW5pbSBl\r\n" +
          "dSB0dXJwaXMgZWdlc3RhcyBwcmV0aXVtIGFlbmVhbiBwaGFyZXRyYSBtYWduYSBhYyBwbGFjZXJh\r\n" +
          "dC4gSW4gbW9sbGlzIG51bmMgc2VkIGlkIHNlbXBlci4gQmliZW5kdW0gdXQgdHJpc3RpcXVlIGV0\r\n" +
          "IGVnZXN0YXMgcXVpcyBpcHN1bSBzdXNwZW5kaXNzZSB1bHRyaWNlcyBncmF2aWRhLiBVcm5hIG1v\r\n" +
          "bGVzdGllIGF0IGVsZW1lbnR1bSBldSBmYWNpbGlzaXMgc2VkLiBBbWV0IHB1cnVzIGdyYXZpZGEg\r\n" +
          "cXVpcyBibGFuZGl0IHR1cnBpcyBjdXJzdXMgaW4gaGFjIGhhYml0YXNzZS4gVml2ZXJyYSBtYXVy\r\n" +
          "aXMgaW4gYWxpcXVhbSBzZW0gZnJpbmdpbGxhIHV0IG1vcmJpLgoKQXVjdG9yIGV1IGF1Z3VlIHV0\r\n" +
          "IGxlY3R1cyBhcmN1IGJpYmVuZHVtIGF0LiBEaWFtIHF1YW0gbnVsbGEgcG9ydHRpdG9yIG1hc3Nh\r\n" +
          "IGlkIG5lcXVlIGFsaXF1YW0uIFV0IGNvbnNlcXVhdCBzZW1wZXIgdml2ZXJyYSBuYW0gbGliZXJv\r\n" +
          "IGp1c3RvIGxhb3JlZXQgc2l0LiBJbXBlcmRpZXQgcHJvaW4gZmVybWVudHVtIGxlbyB2ZWwgb3Jj\r\n" +
          "aSBwb3J0YS4gTmliaCBjcmFzIHB1bHZpbmFyIG1hdHRpcyBudW5jIHNlZC4gTmVxdWUgdm9sdXRw\r\n" +
          "YXQgYWMgdGluY2lkdW50IHZpdGFlIHNlbXBlci4gTWF1cmlzIGluIGFsaXF1YW0gc2VtIGZyaW5n\r\n" +
          "aWxsYSB1dCBtb3JiaS4gSWQgbGVvIGluIHZpdGFlIHR1cnBpcyBtYXNzYS4gUnV0cnVtIHRlbGx1\r\n" +
          "cyBwZWxsZW50ZXNxdWUgZXUgdGluY2lkdW50IHRvcnRvciBhbGlxdWFtIG51bGxhIGZhY2lsaXNp\r\n" +
          "IGNyYXMuIFNlZCBlbGVtZW50dW0gdGVtcHVzIGVnZXN0YXMgc2VkIHNlZCByaXN1cy4gSWQgY29u\r\n" +
          "c2VjdGV0dXIgcHVydXMgdXQgZmF1Y2lidXMuIFRpbmNpZHVudCBhdWd1ZSBpbnRlcmR1bSB2ZWxp\r\n" +
          "dCBldWlzbW9kIGluIHBlbGxlbnRlc3F1ZSBtYXNzYSBwbGFjZXJhdC4gUXVhbSBudWxsYSBwb3J0\r\n" +
          "dGl0b3IgbWFzc2EgaWQuIEN1cmFiaXR1ciB2aXRhZSBudW5jIHNlZCB2ZWxpdCBkaWduaXNzaW0g\r\n" +
          "c29kYWxlcyB1dCBldSBzZW0uIEVuaW0gdXQgc2VtIHZpdmVycmEgYWxpcXVldCBlZ2V0IHNpdCBh\r\n" +
          "bWV0IHRlbGx1cy4gRGlhbSBxdWFtIG51bGxhIHBvcnR0aXRvciBtYXNzYS4gQmliZW5kdW0gZW5p\r\n" +
          "bSBmYWNpbGlzaXMgZ3JhdmlkYSBuZXF1ZSBjb252YWxsaXMuIE1vbGVzdGllIGFjIGZldWdpYXQg\r\n" +
          "c2VkIGxlY3R1cyB2ZXN0aWJ1bHVtIG1hdHRpcyB1bGxhbWNvcnBlciB2ZWxpdCBzZWQuCgpMYWNp\r\n" +
          "bmlhIGF0IHF1aXMgcmlzdXMgc2VkIHZ1bHB1dGF0ZSBvZGlvIHV0LiBWb2x1dHBhdCBsYWN1cyBs\r\n" +
          "YW9yZWV0IG5vbiBjdXJhYml0dXIuIERvbmVjIG1hc3NhIHNhcGllbiBmYXVjaWJ1cyBldCBtb2xl\r\n" +
          "c3RpZSBhYyBmZXVnaWF0IHNlZCBsZWN0dXMuIEF0IGxlY3R1cyB1cm5hIGR1aXMgY29udmFsbGlz\r\n" +
          "IGNvbnZhbGxpcyB0ZWxsdXMgaWQuIEdyYXZpZGEgcXVpcyBibGFuZGl0IHR1cnBpcyBjdXJzdXMg\r\n" +
          "aW4gaGFjIGhhYml0YXNzZSBwbGF0ZWEgZGljdHVtc3QuIEV0IGxpZ3VsYSB1bGxhbWNvcnBlciBt\r\n" +
          "YWxlc3VhZGEgcHJvaW4gbGliZXJvLiBOaXNsIGNvbmRpbWVudHVtIGlkIHZlbmVuYXRpcyBhIGNv\r\n" +
          "bmRpbWVudHVtIHZpdGFlIHNhcGllbiBwZWxsZW50ZXNxdWUuIFBsYWNlcmF0IGluIGVnZXN0YXMg\r\n" +
          "ZXJhdCBpbXBlcmRpZXQgc2VkIGV1aXNtb2QgbmlzaSBwb3J0YSBsb3JlbS4gSWQgb3JuYXJlIGFy\r\n" +
          "Y3Ugb2RpbyB1dC4gVGVsbHVzIG1hdXJpcyBhIGRpYW0gbWFlY2VuYXMgc2VkIGVuaW0gdXQgc2Vt\r\n" +
          "LiBBZGlwaXNjaW5nIGNvbW1vZG8gZWxpdCBhdCBpbXBlcmRpZXQgZHVpIGFjY3Vtc2FuIHNpdCBh\r\n" +
          "bWV0LiBJbiBpYWN1bGlzIG51bmMgc2VkIGF1Z3VlIGxhY3VzIHZpdmVycmEuIE1hc3NhIHRpbmNp\r\n" +
          "ZHVudCBkdWkgdXQgb3JuYXJlIGxlY3R1cyBzaXQgYW1ldC4gU29kYWxlcyB1dCBldSBzZW0gaW50\r\n" +
          "ZWdlciB2aXRhZS4gTW9yYmkgbGVvIHVybmEgbW9sZXN0aWUgYXQgZWxlbWVudHVtIGV1LiBPcm5h\r\n" +
          "cmUgbGVjdHVzIHNpdCBhbWV0IGVzdCBwbGFjZXJhdCBpbiBlZ2VzdGFzLiBOb24gcHVsdmluYXIg\r\n" +
          "bmVxdWUgbGFvcmVldCBzdXNwZW5kaXNzZS4KCk1hbGVzdWFkYSBmYW1lcyBhYyB0dXJwaXMgZWdl\r\n" +
          "c3Rhcy4gQ29uc2VjdGV0dXIgYSBlcmF0IG5hbSBhdCBsZWN0dXMgdXJuYSBkdWlzIGNvbnZhbGxp\r\n" +
          "cyBjb252YWxsaXMuIEFyY3UgZmVsaXMgYmliZW5kdW0gdXQgdHJpc3RpcXVlIGV0IGVnZXN0YXMg\r\n" +
          "cXVpcy4gRmVybWVudHVtIG9kaW8gZXUgZmV1Z2lhdCBwcmV0aXVtIG5pYmggaXBzdW0uIER1aXMg\r\n" +
          "YXQgY29uc2VjdGV0dXIgbG9yZW0gZG9uZWMgbWFzc2Egc2FwaWVuLiBEdWlzIHVsdHJpY2llcyBs\r\n" +
          "YWN1cyBzZWQgdHVycGlzIHRpbmNpZHVudCBpZCBhbGlxdWV0IHJpc3VzIGZldWdpYXQuIElkIG5l\r\n" +
          "cXVlIGFsaXF1YW0gdmVzdGlidWx1bSBtb3JiaSBibGFuZGl0IGN1cnN1cyByaXN1cyBhdC4gQ29t\r\n" +
          "bW9kbyBudWxsYSBmYWNpbGlzaSBudWxsYW0gdmVoaWN1bGEgaXBzdW0gYS4gTnVuYyBtYXR0aXMg\r\n" +
          "ZW5pbSB1dCB0ZWxsdXMgZWxlbWVudHVtLiBQcm9pbiBzYWdpdHRpcyBuaXNsIHJob25jdXMgbWF0\r\n" +
          "dGlzLiBFbmltIHV0IHNlbSB2aXZlcnJhIGFsaXF1ZXQgZWdldCBzaXQgYW1ldC4gU2VkIGV1aXNt\r\n" +
          "b2QgbmlzaSBwb3J0YSBsb3JlbS4KCkVuaW0gZmFjaWxpc2lzIGdyYXZpZGEgbmVxdWUgY29udmFs\r\n" +
          "bGlzIGEgY3JhcyBzZW1wZXIgYXVjdG9yIG5lcXVlLiBEaWFtIHNvbGxpY2l0dWRpbiB0ZW1wb3Ig\r\n" +
          "aWQgZXUgbmlzbC4gTWFnbmEgZnJpbmdpbGxhIHVybmEgcG9ydHRpdG9yIHJob25jdXMgZG9sb3Ig\r\n" +
          "cHVydXMgbm9uIGVuaW0gcHJhZXNlbnQuIFZpdGFlIHByb2luIHNhZ2l0dGlzIG5pc2wgcmhvbmN1\r\n" +
          "cyBtYXR0aXMgcmhvbmN1cyB1cm5hLiBMdWN0dXMgYWNjdW1zYW4gdG9ydG9yIHBvc3VlcmUgYWMg\r\n" +
          "dXQgY29uc2VxdWF0IHNlbXBlciB2aXZlcnJhIG5hbS4gVWx0cmljZXMgZXJvcyBpbiBjdXJzdXMg\r\n" +
          "dHVycGlzIG1hc3NhIHRpbmNpZHVudC4gT2RpbyBwZWxsZW50ZXNxdWUgZGlhbSB2b2x1dHBhdCBj\r\n" +
          "b21tb2RvIHNlZCBlZ2VzdGFzLiBBdWd1ZSBuZXF1ZSBncmF2aWRhIGluIGZlcm1lbnR1bSBldCBz\r\n" +
          "b2xsaWNpdHVkaW4gYWMuIFN1c2NpcGl0IGFkaXBpc2NpbmcgYmliZW5kdW0gZXN0IHVsdHJpY2ll\r\n" +
          "cyBpbnRlZ2VyIHF1aXMuIE51bmMgbm9uIGJsYW5kaXQgbWFzc2EgZW5pbSBuZWMgZHVpIG51bmMg\r\n" +
          "bWF0dGlzLiBNb3JiaSBxdWlzIGNvbW1vZG8gb2RpbyBhZW5lYW4gc2VkIGFkaXBpc2NpbmcgZGlh\r\n" +
          "bS4gVGVsbHVzIGF0IHVybmEgY29uZGltZW50dW0gbWF0dGlzIHBlbGxlbnRlc3F1ZSBpZCBuaWJo\r\n" +
          "IHRvcnRvci4gQXQgYXVndWUgZWdldCBhcmN1IGRpY3R1bSB2YXJpdXMgZHVpcyBhdC4gVmFyaXVz\r\n" +
          "IG1vcmJpIGVuaW0gbnVuYyBmYXVjaWJ1cyBhIHBlbGxlbnRlc3F1ZSBzaXQgYW1ldCBwb3J0dGl0\r\n" +
          "b3IuIE5lYyBmZXVnaWF0IGluIGZlcm1lbnR1bSBwb3N1ZXJlIHVybmEgbmVjLiBGYW1lcyBhYyB0\r\n" +
          "dXJwaXMgZWdlc3RhcyBtYWVjZW5hcyBwaGFyZXRyYSBjb252YWxsaXMgcG9zdWVyZS4gQXJjdSBj\r\n" +
          "dXJzdXMgZXVpc21vZCBxdWlzIHZpdmVycmEgbmliaCBjcmFzIHB1bHZpbmFyIG1hdHRpcy4gUXVh\r\n" +
          "bSBxdWlzcXVlIGlkIGRpYW0gdmVsIHF1YW0gZWxlbWVudHVtIHB1bHZpbmFyIGV0aWFtLiBQb3J0\r\n" +
          "YSBub24gcHVsdmluYXIgbmVxdWUgbGFvcmVldCBzdXNwZW5kaXNzZSBpbnRlcmR1bSBjb25zZWN0\r\n" +
          "ZXR1ciBsaWJlcm8uIFBhcnR1cmllbnQgbW9udGVzIG5hc2NldHVyIHJpZGljdWx1cyBtdXMgbWF1\r\n" +
          "cmlzIHZpdGFlIHVsdHJpY2llcy4KClZlbCBmYWNpbGlzaXMgdm9sdXRwYXQgZXN0IHZlbGl0IGVn\r\n" +
          "ZXN0YXMgZHVpIGlkIG9ybmFyZS4gVnVscHV0YXRlIG9kaW8gdXQgZW5pbSBibGFuZGl0IHZvbHV0\r\n" +
          "cGF0LiBDb25ndWUgcXVpc3F1ZSBlZ2VzdGFzIGRpYW0gaW4gYXJjdSBjdXJzdXMuIENvbnZhbGxp\r\n" +
          "cyBhZW5lYW4gZXQgdG9ydG9yIGF0IHJpc3VzIHZpdmVycmEgYWRpcGlzY2luZy4gSWQgY29uc2Vj\r\n" +
          "dGV0dXIgcHVydXMgdXQgZmF1Y2lidXMgcHVsdmluYXIuIFNvbGxpY2l0dWRpbiB0ZW1wb3IgaWQg\r\n" +
          "ZXUgbmlzbCBudW5jIG1pIGlwc3VtIGZhdWNpYnVzIHZpdGFlLiBBY2N1bXNhbiBpbiBuaXNsIG5p\r\n" +
          "c2kgc2NlbGVyaXNxdWUgZXUgdWx0cmljZXMgdml0YWUgYXVjdG9yLiBVcm5hIG1vbGVzdGllIGF0\r\n" +
          "IGVsZW1lbnR1bSBldSBmYWNpbGlzaXMgc2VkLiBEdWkgdXQgb3JuYXJlIGxlY3R1cyBzaXQgYW1l\r\n" +
          "dCBlc3QgcGxhY2VyYXQgaW4uIFVsbGFtY29ycGVyIGEgbGFjdXMgdmVzdGlidWx1bSBzZWQgYXJj\r\n" +
          "dSBub24gb2RpbyBldWlzbW9kLiBWZWwgcXVhbSBlbGVtZW50dW0gcHVsdmluYXIgZXRpYW0gbm9u\r\n" +
          "LiBBZGlwaXNjaW5nIGVsaXQgdXQgYWxpcXVhbSBwdXJ1cyBzaXQgYW1ldCBsdWN0dXMgdmVuZW5h\r\n" +
          "dGlzLgoKVGluY2lkdW50IHRvcnRvciBhbGlxdWFtIG51bGxhIGZhY2lsaXNpLiBBbGlxdWV0IGVn\r\n" +
          "ZXQgc2l0IGFtZXQgdGVsbHVzIGNyYXMgYWRpcGlzY2luZyBlbmltIGV1LiBBbWV0IHB1cnVzIGdy\r\n" +
          "YXZpZGEgcXVpcyBibGFuZGl0IHR1cnBpcy4gSnVzdG8gZWdldCBtYWduYSBmZXJtZW50dW0gaWFj\r\n" +
          "dWxpcy4gUmlzdXMgdWx0cmljaWVzIHRyaXN0aXF1ZSBudWxsYSBhbGlxdWV0IGVuaW0gdG9ydG9y\r\n" +
          "IGF0IGF1Y3RvciB1cm5hLiBQdXJ1cyB1dCBmYXVjaWJ1cyBwdWx2aW5hciBlbGVtZW50dW0gaW50\r\n" +
          "ZWdlciBlbmltIG5lcXVlIHZvbHV0cGF0LiBNYXVyaXMgY3Vyc3VzIG1hdHRpcyBtb2xlc3RpZSBh\r\n" +
          "IGlhY3VsaXMgYXQuIERhcGlidXMgdWx0cmljZXMgaW4gaWFjdWxpcyBudW5jIHNlZCBhdWd1ZS4g\r\n" +
          "QmliZW5kdW0gdXQgdHJpc3RpcXVlIGV0IGVnZXN0YXMgcXVpcyBpcHN1bSBzdXNwZW5kaXNzZSB1\r\n" +
          "bHRyaWNlcy4gQW1ldCBtYXNzYSB2aXRhZSB0b3J0b3IgY29uZGltZW50dW0gbGFjaW5pYS4gQ29u\r\n" +
          "c2VxdWF0IHNlbXBlciB2aXZlcnJhIG5hbSBsaWJlcm8ganVzdG8gbGFvcmVldCBzaXQgYW1ldCBj\r\n" +
          "dXJzdXMuIFRyaXN0aXF1ZSBzZW5lY3R1cyBldCBuZXR1cyBldC4gVWx0cmljZXMgZHVpIHNhcGll\r\n" +
          "biBlZ2V0IG1pIHByb2luIHNlZCBsaWJlcm8uIFBvc3VlcmUgc29sbGljaXR1ZGluIGFsaXF1YW0g\r\n" +
          "dWx0cmljZXMgc2FnaXR0aXMgb3JjaSBhIHNjZWxlcmlzcXVlLiBBbnRlIGluIG5pYmggbWF1cmlz\r\n" +
          "IGN1cnN1cyBtYXR0aXMgbW9sZXN0aWUgYSBpYWN1bGlzIGF0LgoKUXVpcyBlbGVpZmVuZCBxdWFt\r\n" +
          "IGFkaXBpc2Npbmcgdml0YWUgcHJvaW4gc2FnaXR0aXMgbmlzbCByaG9uY3VzLiBSdXRydW0gdGVs\r\n" +
          "bHVzIHBlbGxlbnRlc3F1ZSBldSB0aW5jaWR1bnQgdG9ydG9yIGFsaXF1YW0gbnVsbGEgZmFjaWxp\r\n" +
          "c2kuIExvYm9ydGlzIGZldWdpYXQgdml2YW11cyBhdCBhdWd1ZSBlZ2V0IGFyY3UgZGljdHVtIHZh\r\n" +
          "cml1cy4gQ29uc2VxdWF0IG1hdXJpcyBudW5jIGNvbmd1ZSBuaXNpIHZpdGFlIHN1c2NpcGl0IHRl\r\n" +
          "bGx1cy4gRmFjaWxpc2lzIGdyYXZpZGEgbmVxdWUgY29udmFsbGlzIGEgY3JhcyBzZW1wZXIgYXVj\r\n" +
          "dG9yIG5lcXVlLiBNb2xlc3RpZSBhIGlhY3VsaXMgYXQgZXJhdC4gUXVpcyB2ZWwgZXJvcyBkb25l\r\n" +
          "YyBhYy4gTW9yYmkgbGVvIHVybmEgbW9sZXN0aWUgYXQgZWxlbWVudHVtLiBNb3JiaSB0cmlzdGlx\r\n" +
          "dWUgc2VuZWN0dXMgZXQgbmV0dXMgZXQgbWFsZXN1YWRhIGZhbWVzIGFjIHR1cnBpcy4gRmF1Y2li\r\n" +
          "dXMgdml0YWUgYWxpcXVldCBuZWMgdWxsYW1jb3JwZXIgc2l0IGFtZXQgcmlzdXMgbnVsbGFtIGVn\r\n" +
          "ZXQuIE9kaW8gdGVtcG9yIG9yY2kgZGFwaWJ1cyB1bHRyaWNlcy4gVHJpc3RpcXVlIGV0IGVnZXN0\r\n" +
          "YXMgcXVpcyBpcHN1bSBzdXNwZW5kaXNzZS4gTWFzc2EgdGVtcG9yIG5lYyBmZXVnaWF0IG5pc2wg\r\n" +
          "cHJldGl1bSBmdXNjZSBpZCB2ZWxpdC4gRW5pbSBudWxsYSBhbGlxdWV0IHBvcnR0aXRvciBsYWN1\r\n" +
          "cyBsdWN0dXMgYWNjdW1zYW4gdG9ydG9yLiBFdSB2b2x1dHBhdCBvZGlvIGZhY2lsaXNpcyBtYXVy\r\n" +
          "aXMgc2l0IGFtZXQgbWFzc2Egdml0YWUuCgpVdCBldSBzZW0gaW50ZWdlciB2aXRhZSBqdXN0byBl\r\n" +
          "Z2V0IG1hZ25hIGZlcm1lbnR1bS4gTmV0dXMgZXQgbWFsZXN1YWRhIGZhbWVzIGFjIHR1cnBpcyBl\r\n" +
          "Z2VzdGFzLiBWb2x1dHBhdCBsYWN1cyBsYW9yZWV0IG5vbiBjdXJhYml0dXIgZ3JhdmlkYSBhcmN1\r\n" +
          "IGFjLiBUaW5jaWR1bnQgbG9ib3J0aXMgZmV1Z2lhdCB2aXZhbXVzIGF0IGF1Z3VlLiBWaXRhZSB0\r\n" +
          "dXJwaXMgbWFzc2Egc2VkIGVsZW1lbnR1bSB0ZW1wdXMgZWdlc3Rhcy4gTG9ib3J0aXMgc2NlbGVy\r\n" +
          "aXNxdWUgZmVybWVudHVtIGR1aSBmYXVjaWJ1cyBpbiBvcm5hcmUgcXVhbSB2aXZlcnJhIG9yY2ku\r\n" +
          "IEV1IHNjZWxlcmlzcXVlIGZlbGlzIGltcGVyZGlldCBwcm9pbiBmZXJtZW50dW0gbGVvIHZlbCBv\r\n" +
          "cmNpIHBvcnRhLiBUZW1wdXMgZWdlc3RhcyBzZWQgc2VkIHJpc3VzIHByZXRpdW0gcXVhbSB2dWxw\r\n" +
          "dXRhdGUuIEFkaXBpc2NpbmcgdHJpc3RpcXVlIHJpc3VzIG5lYyBmZXVnaWF0IGluLiBFbGVtZW50\r\n" +
          "dW0gZXUgZmFjaWxpc2lzIHNlZCBvZGlvIG1vcmJpIHF1aXMuIE5hbSBsaWJlcm8ganVzdG8gbGFv\r\n" +
          "cmVldCBzaXQgYW1ldCBjdXJzdXMgc2l0LiBTY2VsZXJpc3F1ZSBpbiBkaWN0dW0gbm9uIGNvbnNl\r\n" +
          "Y3RldHVyIGEgZXJhdCBuYW0gYXQgbGVjdHVzLiBWaXZlcnJhIG1hZWNlbmFzIGFjY3Vtc2FuIGxh\r\n" +
          "Y3VzIHZlbC4gRmF1Y2lidXMgZXQgbW9sZXN0aWUgYWMgZmV1Z2lhdCBzZWQgbGVjdHVzIHZlc3Rp\r\n" +
          "YnVsdW0gbWF0dGlzIHVsbGFtY29ycGVyLiBGYW1lcyBhYyB0dXJwaXMgZWdlc3RhcyBtYWVjZW5h\r\n" +
          "cy4KClNpdCBhbWV0IHRlbGx1cyBjcmFzIGFkaXBpc2NpbmcgZW5pbSBldSB0dXJwaXMgZWdlc3Rh\r\n" +
          "cy4gUXVpcyB2YXJpdXMgcXVhbSBxdWlzcXVlIGlkIGRpYW0gdmVsIHF1YW0gZWxlbWVudHVtIHB1\r\n" +
          "bHZpbmFyLiBTZW1wZXIgZmV1Z2lhdCBuaWJoIHNlZCBwdWx2aW5hciBwcm9pbiBncmF2aWRhIGhl\r\n" +
          "bmRyZXJpdCBsZWN0dXMgYS4gVG9ydG9yIHBvc3VlcmUgYWMgdXQgY29uc2VxdWF0IHNlbXBlciB2\r\n" +
          "aXZlcnJhIG5hbSBsaWJlcm8ganVzdG8uIEVnZXN0YXMgZnJpbmdpbGxhIHBoYXNlbGx1cyBmYXVj\r\n" +
          "aWJ1cyBzY2VsZXJpc3F1ZS4gRmV1Z2lhdCBuaWJoIHNlZCBwdWx2aW5hciBwcm9pbi4gQ3VtIHNv\r\n" +
          "Y2lpcyBuYXRvcXVlIHBlbmF0aWJ1cyBldCBtYWduaXMgZGlzIHBhcnR1cmllbnQuIEFyY3UgZmVs\r\n" +
          "aXMgYmliZW5kdW0gdXQgdHJpc3RpcXVlIGV0IGVnZXN0YXMgcXVpcyBpcHN1bS4gT2RpbyBtb3Ji\r\n" +
          "aSBxdWlzIGNvbW1vZG8gb2RpbyBhZW5lYW4gc2VkIGFkaXBpc2NpbmcgZGlhbS4gQXQgcmlzdXMg\r\n" +
          "dml2ZXJyYSBhZGlwaXNjaW5nIGF0IGluIHRlbGx1cyBpbnRlZ2VyLiBMYWN1cyBzZWQgdml2ZXJy\r\n" +
          "YSB0ZWxsdXMgaW4gaGFjIGhhYml0YXNzZSBwbGF0ZWEgZGljdHVtc3QgdmVzdGlidWx1bS4gRHVp\r\n" +
          "IGlkIG9ybmFyZSBhcmN1IG9kaW8gdXQgc2VtIG51bGxhIHBoYXJldHJhLiBFbGVtZW50dW0gcHVs\r\n" +
          "dmluYXIgZXRpYW0gbm9uIHF1YW0gbGFjdXMgc3VzcGVuZGlzc2UgZmF1Y2lidXMgaW50ZXJkdW0u\r\n" +
          "IEF0IGltcGVyZGlldCBkdWkgYWNjdW1zYW4gc2l0IGFtZXQgbnVsbGEgZmFjaWxpc2kuIFVsdHJp\r\n" +
          "Y2llcyBsYWN1cyBzZWQgdHVycGlzIHRpbmNpZHVudC4gRWdlc3RhcyBlcmF0IGltcGVyZGlldCBz\r\n" +
          "ZWQgZXVpc21vZCBuaXNpIHBvcnRhLiBBY2N1bXNhbiBpbiBuaXNsIG5pc2kgc2NlbGVyaXNxdWUg\r\n" +
          "ZXUgdWx0cmljZXMgdml0YWUuIFBoYXJldHJhIHNpdCBhbWV0IGFsaXF1YW0gaWQuIElhY3VsaXMg\r\n" +
          "dXJuYSBpZCB2b2x1dHBhdCBsYWN1cyBsYW9yZWV0LgoKTW9yYmkgbGVvIHVybmEgbW9sZXN0aWUg\r\n" +
          "YXQgZWxlbWVudHVtLiBUZWxsdXMgaW50ZWdlciBmZXVnaWF0IHNjZWxlcmlzcXVlIHZhcml1cyBt\r\n" +
          "b3JiaS4gRXUgbmlzbCBudW5jIG1pIGlwc3VtIGZhdWNpYnVzLiBDcmFzIHNlbXBlciBhdWN0b3Ig\r\n" +
          "bmVxdWUgdml0YWUgdGVtcHVzIHF1YW0gcGVsbGVudGVzcXVlLiBNYWduYSBmZXJtZW50dW0gaWFj\r\n" +
          "dWxpcyBldSBub24gZGlhbS4gTWF1cmlzIHVsdHJpY2VzIGVyb3MgaW4gY3Vyc3VzIHR1cnBpcyBt\r\n" +
          "YXNzYSB0aW5jaWR1bnQuIENvbmd1ZSBuaXNpIHZpdGFlIHN1c2NpcGl0IHRlbGx1cyBtYXVyaXMu\r\n" +
          "IE5hbSBhdCBsZWN0dXMgdXJuYSBkdWlzIGNvbnZhbGxpcyBjb252YWxsaXMuIFF1YW0gbGFjdXMg\r\n" +
          "c3VzcGVuZGlzc2UgZmF1Y2lidXMgaW50ZXJkdW0gcG9zdWVyZSBsb3JlbSBpcHN1bS4gUXVpcyBo\r\n" +
          "ZW5kcmVyaXQgZG9sb3IgbWFnbmEgZWdldCBlc3QgbG9yZW0uIFBlbGxlbnRlc3F1ZSBhZGlwaXNj\r\n" +
          "aW5nIGNvbW1vZG8gZWxpdCBhdCBpbXBlcmRpZXQgZHVpLiBWYXJpdXMgc2l0IGFtZXQgbWF0dGlz\r\n" +
          "IHZ1bHB1dGF0ZSBlbmltIG51bGxhIGFsaXF1ZXQgcG9ydHRpdG9yLiBPcm5hcmUgYXJjdSBvZGlv\r\n" +
          "IHV0IHNlbSBudWxsYSBwaGFyZXRyYSBkaWFtIHNpdC4gTmlzaSBzY2VsZXJpc3F1ZSBldSB1bHRy\r\n" +
          "aWNlcyB2aXRhZS4gUGhhcmV0cmEgcGhhcmV0cmEgbWFzc2EgbWFzc2EgdWx0cmljaWVzIG1pIHF1\r\n" +
          "aXMgaGVuZHJlcml0LiBQb3J0YSBuaWJoIHZlbmVuYXRpcyBjcmFzIHNlZCBmZWxpcyBlZ2V0IHZl\r\n" +
          "bGl0LiBWb2x1dHBhdCBjb25zZXF1YXQgbWF1cmlzIG51bmMgY29uZ3VlIG5pc2kuIEZhbWVzIGFj\r\n" +
          "IHR1cnBpcyBlZ2VzdGFzIHNlZCB0ZW1wdXMgdXJuYS4KCkZlcm1lbnR1bSBsZW8gdmVsIG9yY2kg\r\n" +
          "cG9ydGEgbm9uIHB1bHZpbmFyIG5lcXVlIGxhb3JlZXQuIEZhdWNpYnVzIG9ybmFyZSBzdXNwZW5k\r\n" +
          "aXNzZSBzZWQgbmlzaSBsYWN1cyBzZWQuIFR1cnBpcyBtYXNzYSBzZWQgZWxlbWVudHVtIHRlbXB1\r\n" +
          "cyBlZ2VzdGFzIHNlZC4gRG9uZWMgZXQgb2RpbyBwZWxsZW50ZXNxdWUgZGlhbSB2b2x1dHBhdCBj\r\n" +
          "b21tb2RvIHNlZC4gSWQgY3Vyc3VzIG1ldHVzIGFsaXF1YW0gZWxlaWZlbmQgbWkgaW4uIE9kaW8g\r\n" +
          "dXQgZW5pbSBibGFuZGl0IHZvbHV0cGF0IG1hZWNlbmFzIHZvbHV0cGF0IGJsYW5kaXQgYWxpcXVh\r\n" +
          "bS4gUG9ydHRpdG9yIG1hc3NhIGlkIG5lcXVlIGFsaXF1YW0gdmVzdGlidWx1bSBtb3JiaSBibGFu\r\n" +
          "ZGl0IGN1cnN1cy4gVHVycGlzIGN1cnN1cyBpbiBoYWMgaGFiaXRhc3NlIHBsYXRlYSBkaWN0dW1z\r\n" +
          "dCBxdWlzcXVlLiBFZ2V0IG51bmMgc2NlbGVyaXNxdWUgdml2ZXJyYSBtYXVyaXMgaW4gYWxpcXVh\r\n" +
          "bSBzZW0gZnJpbmdpbGxhLiBOZWMgZHVpIG51bmMgbWF0dGlzIGVuaW0gdXQuIE5pc2kgc2NlbGVy\r\n" +
          "aXNxdWUgZXUgdWx0cmljZXMgdml0YWUgYXVjdG9yIGV1IGF1Z3VlIHV0IGxlY3R1cy4gU2VtcGVy\r\n" +
          "IGF1Y3RvciBuZXF1ZSB2aXRhZSB0ZW1wdXMgcXVhbSBwZWxsZW50ZXNxdWUgbmVjIG5hbS4gTmVx\r\n" +
          "dWUgb3JuYXJlIGFlbmVhbiBldWlzbW9kIGVsZW1lbnR1bSBuaXNpIHF1aXMuCgpOdWxsYSBmYWNp\r\n" +
          "bGlzaSBjcmFzIGZlcm1lbnR1bSBvZGlvIGV1IGZldWdpYXQuIER1aXMgYXQgY29uc2VjdGV0dXIg\r\n" +
          "bG9yZW0gZG9uZWMgbWFzc2EuIFByYWVzZW50IHNlbXBlciBmZXVnaWF0IG5pYmggc2VkIHB1bHZp\r\n" +
          "bmFyIHByb2luLiBVbGxhbWNvcnBlciBhIGxhY3VzIHZlc3RpYnVsdW0gc2VkIGFyY3Ugbm9uIG9k\r\n" +
          "aW8gZXVpc21vZCBsYWNpbmlhLiBFbmltIGRpYW0gdnVscHV0YXRlIHV0IHBoYXJldHJhIHNpdCBh\r\n" +
          "bWV0LiBOdW5jIGZhdWNpYnVzIGEgcGVsbGVudGVzcXVlIHNpdCBhbWV0IHBvcnR0aXRvciBlZ2V0\r\n" +
          "LiBNYXNzYSB1bHRyaWNpZXMgbWkgcXVpcyBoZW5kcmVyaXQgZG9sb3IgbWFnbmEgZWdldCBlc3Qu\r\n" +
          "IFB1bHZpbmFyIG1hdHRpcyBudW5jIHNlZCBibGFuZGl0IGxpYmVyby4gVml0YWUgbnVuYyBzZWQg\r\n" +
          "dmVsaXQgZGlnbmlzc2ltIHNvZGFsZXMuIFBhcnR1cmllbnQgbW9udGVzIG5hc2NldHVyIHJpZGlj\r\n" +
          "dWx1cyBtdXMgbWF1cmlzIHZpdGFlIHVsdHJpY2llcy4gRWdldCBmZWxpcyBlZ2V0IG51bmMgbG9i\r\n" +
          "b3J0aXMgbWF0dGlzIGFsaXF1YW0gZmF1Y2lidXMgcHVydXMgaW4uIEZhY2lsaXNpIG51bGxhbSB2\r\n" +
          "ZWhpY3VsYSBpcHN1bSBhIGFyY3UgY3Vyc3VzLiBFbmltIGRpYW0gdnVscHV0YXRlIHV0IHBoYXJl\r\n" +
          "dHJhIHNpdCBhbWV0LiBTZWQgcmlzdXMgcHJldGl1bSBxdWFtIHZ1bHB1dGF0ZSBkaWduaXNzaW0g\r\n" +
          "c3VzcGVuZGlzc2UgaW4uIEdyYXZpZGEgcXVpcyBibGFuZGl0IHR1cnBpcyBjdXJzdXMuIE1hdHRp\r\n" +
          "cyBwZWxsZW50ZXNxdWUgaWQgbmliaCB0b3J0b3IuCgpVdCBwaGFyZXRyYSBzaXQgYW1ldCBhbGlx\r\n" +
          "dWFtIGlkLiBEb2xvciBzZWQgdml2ZXJyYSBpcHN1bSBudW5jIGFsaXF1ZXQuIFB1cnVzIHZpdmVy\r\n" +
          "cmEgYWNjdW1zYW4gaW4gbmlzbCBuaXNpIHNjZWxlcmlzcXVlIGV1LiBVbHRyaWNlcyB0aW5jaWR1\r\n" +
          "bnQgYXJjdSBub24gc29kYWxlcyBuZXF1ZSBzb2RhbGVzIHV0LiBOdW5jIHZlbCByaXN1cyBjb21t\r\n" +
          "b2RvIHZpdmVycmEgbWFlY2VuYXMgYWNjdW1zYW4gbGFjdXMuIFNlbSBldCB0b3J0b3IgY29uc2Vx\r\n" +
          "dWF0IGlkIHBvcnRhIG5pYmggdmVuZW5hdGlzIGNyYXMuIEZlcm1lbnR1bSBvZGlvIGV1IGZldWdp\r\n" +
          "YXQgcHJldGl1bSBuaWJoIGlwc3VtIGNvbnNlcXVhdCBuaXNsLiBBdCB0ZWxsdXMgYXQgdXJuYSBj\r\n" +
          "b25kaW1lbnR1bSBtYXR0aXMgcGVsbGVudGVzcXVlIGlkIG5pYmggdG9ydG9yLiBQaGFyZXRyYSBl\r\n" +
          "dCB1bHRyaWNlcyBuZXF1ZSBvcm5hcmUuIFZpdGFlIHRvcnRvciBjb25kaW1lbnR1bSBsYWNpbmlh\r\n" +
          "IHF1aXMgdmVsIGVyb3MgZG9uZWMgYWMuIE9ybmFyZSBzdXNwZW5kaXNzZSBzZWQgbmlzaSBsYWN1\r\n" +
          "cyBzZWQgdml2ZXJyYSB0ZWxsdXMuIFNhZ2l0dGlzIGlkIGNvbnNlY3RldHVyIHB1cnVzIHV0IGZh\r\n" +
          "dWNpYnVzLiBWb2x1dHBhdCBzZWQgY3JhcyBvcm5hcmUgYXJjdSBkdWkuIEVyYXQgcGVsbGVudGVz\r\n" +
          "cXVlIGFkaXBpc2NpbmcgY29tbW9kbyBlbGl0IGF0IGltcGVyZGlldC4gTGFvcmVldCBzdXNwZW5k\r\n" +
          "aXNzZSBpbnRlcmR1bSBjb25zZWN0ZXR1ciBsaWJlcm8uCgpOZXF1ZSBlZ2VzdGFzIGNvbmd1ZSBx\r\n" +
          "dWlzcXVlIGVnZXN0YXMuIEVsaXQgdWxsYW1jb3JwZXIgZGlnbmlzc2ltIGNyYXMgdGluY2lkdW50\r\n" +
          "IGxvYm9ydGlzLiBOaXNpIHNjZWxlcmlzcXVlIGV1IHVsdHJpY2VzIHZpdGFlIGF1Y3RvciBldSBh\r\n" +
          "dWd1ZS4gVXQgdGVsbHVzIGVsZW1lbnR1bSBzYWdpdHRpcyB2aXRhZSBldCBsZW8uIE1hbGVzdWFk\r\n" +
          "YSBiaWJlbmR1bSBhcmN1IHZpdGFlIGVsZW1lbnR1bSBjdXJhYml0dXIgdml0YWUgbnVuYyBzZWQu\r\n" +
          "IFNvbGxpY2l0dWRpbiBhbGlxdWFtIHVsdHJpY2VzIHNhZ2l0dGlzIG9yY2kgYSBzY2VsZXJpc3F1\r\n" +
          "ZS4gU2VuZWN0dXMgZXQgbmV0dXMgZXQgbWFsZXN1YWRhIGZhbWVzIGFjIHR1cnBpcyBlZ2VzdGFz\r\n" +
          "IGludGVnZXIuIER1aXMgdXQgZGlhbSBxdWFtIG51bGxhIHBvcnR0aXRvciBtYXNzYS4gQ29tbW9k\r\n" +
          "byBudWxsYSBmYWNpbGlzaSBudWxsYW0gdmVoaWN1bGEgaXBzdW0gYSBhcmN1IGN1cnN1cy4gQSBh\r\n" +
          "cmN1IGN1cnN1cyB2aXRhZSBjb25ndWUgbWF1cmlzIHJob25jdXMgYWVuZWFuLiBBdCBjb25zZWN0\r\n" +
          "ZXR1ciBsb3JlbSBkb25lYyBtYXNzYSBzYXBpZW4gZmF1Y2lidXMgZXQgbW9sZXN0aWUgYWMuIFNl\r\n" +
          "ZCBibGFuZGl0IGxpYmVybyB2b2x1dHBhdCBzZWQuIEVsaXQgc2NlbGVyaXNxdWUgbWF1cmlzIHBl\r\n" +
          "bGxlbnRlc3F1ZSBwdWx2aW5hci4gT2RpbyBtb3JiaSBxdWlzIGNvbW1vZG8gb2RpbyBhZW5lYW4g\r\n" +
          "c2VkIGFkaXBpc2NpbmcgZGlhbSBkb25lYy4gQ3Vyc3VzIGluIGhhYyBoYWJpdGFzc2UgcGxhdGVh\r\n" +
          "IGRpY3R1bXN0IHF1aXNxdWUgc2FnaXR0aXMgcHVydXMgc2l0LiBOYW0gbGliZXJvIGp1c3RvIGxh\r\n" +
          "b3JlZXQgc2l0IGFtZXQgY3Vyc3VzLiBNb2xsaXMgbnVuYyBzZWQgaWQgc2VtcGVyIHJpc3VzLiBQ\r\n" +
          "aGFyZXRyYSBjb252YWxsaXMgcG9zdWVyZSBtb3JiaSBsZW8gdXJuYSBtb2xlc3RpZSBhdCBlbGVt\r\n" +
          "ZW50dW0uCgpVbGxhbWNvcnBlciBtb3JiaSB0aW5jaWR1bnQgb3JuYXJlIG1hc3NhIGVnZXQgZWdl\r\n" +
          "c3RhcyBwdXJ1cy4gQSBzY2VsZXJpc3F1ZSBwdXJ1cyBzZW1wZXIgZWdldCBkdWlzIGF0IHRlbGx1\r\n" +
          "cyBhdCB1cm5hLiBWZWxpdCBzZWQgdWxsYW1jb3JwZXIgbW9yYmkgdGluY2lkdW50LiBTYWdpdHRp\r\n" +
          "cyBuaXNsIHJob25jdXMgbWF0dGlzIHJob25jdXMgdXJuYSBuZXF1ZSB2aXZlcnJhIGp1c3RvIG5l\r\n" +
          "Yy4gUXVhbSBpZCBsZW8gaW4gdml0YWUuIE9ybmFyZSBhcmN1IGR1aSB2aXZhbXVzIGFyY3UgZmVs\r\n" +
          "aXMgYmliZW5kdW0gdXQgdHJpc3RpcXVlIGV0LiBMZWN0dXMgcHJvaW4gbmliaCBuaXNsIGNvbmRp\r\n" +
          "bWVudHVtIGlkIHZlbmVuYXRpcy4gTWF1cmlzIGEgZGlhbSBtYWVjZW5hcyBzZWQgZW5pbSB1dCBz\r\n" +
          "ZW0gdml2ZXJyYS4gRmV1Z2lhdCBuaXNsIHByZXRpdW0gZnVzY2UgaWQgdmVsaXQuIFZpdGFlIHR1\r\n" +
          "cnBpcyBtYXNzYSBzZWQgZWxlbWVudHVtIHRlbXB1cyBlZ2VzdGFzLiBEaWFtIHV0IHZlbmVuYXRp\r\n" +
          "cyB0ZWxsdXMgaW4gbWV0dXMgdnVscHV0YXRlLiBGZXJtZW50dW0gcG9zdWVyZSB1cm5hIG5lYyB0\r\n" +
          "aW5jaWR1bnQuIEF1Y3RvciB1cm5hIG51bmMgaWQgY3Vyc3VzIG1ldHVzIGFsaXF1YW0uCg==";
  
  // endregion
  
  private static final Map<String, String> EXPECTED_MAP = new HashMap<String, String>() {{
    put("", "");
    put("f", "Zg==");
    put("fo", "Zm8=");
    put("foo", "Zm9v");
    put("foob", "Zm9vYg==");
    put("fooba", "Zm9vYmE=");
    put("foobar", "Zm9vYmFy");
  }};
  
  @Test
  public void whenDataIsEncryptedToBase64_thenEncryptSuccessfully() throws CipherException {
    CipherFactory factory      = CipherFactory.getInstance();
    ICipher       cipherBase64 = factory.get(BASE64);
    
    for (String data : EXPECTED_MAP.keySet()) {
      byte[] encryptedData = cipherBase64.encrypt(null, null, data.getBytes(UTF_8));
      Assert.assertNotNull(encryptedData);
      
      String encryptedText = new String(encryptedData);
      String expectedValue = EXPECTED_MAP.get(data);
      System.out.printf("Data: %s / Expected: %s / Encrypted: %s%n",
          data, expectedValue, encryptedText);
      
      Assert.assertEquals(expectedValue, encryptedText);
    }
  }
  
  @Test
  public void whenEncryptLargeTextToBase64_thenEncryptSuccessfully() throws CipherException {
    CipherFactory factory      = CipherFactory.getInstance();
    ICipher       cipherBase64 = factory.get(BASE64);
    
    byte[] encryptedData = cipherBase64.encrypt(null, null, LARGE_TEXT.getBytes(UTF_8));
    String encryptedText = new String(encryptedData, Charset.defaultCharset());
    Assert.assertNotNull(encryptedData);
    Assert.assertEquals(BASE64_LARGE_TEXT, encryptedText);
  }
  
  @Test
  public void whenEncryptFileToBase64_thenDecryptFileSuccessfully()
      throws CipherException, IOException {
    CipherFactory factory      = CipherFactory.getInstance();
    ICipher       cipherBase64 = factory.get(BASE64);
    
    String data         = "foobar";
    File   originalFile = File.createTempFile("cipherizy-decrypt-test", ".tmp");
    Files.write(originalFile.toPath(), data.getBytes(UTF_8));
    originalFile.deleteOnExit();
    
    byte[] encryptedData = cipherBase64.encrypt(null, null, originalFile);
    String encryptedText = new String(encryptedData, Charset.defaultCharset());
    Assert.assertNotNull(encryptedData);
    Assert.assertNotNull(encryptedText);
    
    File   decryptedFile        = cipherBase64.decryptToFile(null, null, encryptedData);
    String decryptedFileContent = new String(Files.readAllBytes(decryptedFile.toPath()), UTF_8);
    Assert.assertEquals("Original file content must be equals to decrypted file content",
        data, decryptedFileContent);
  }
  
  @Test
  public void whenDataIsEncryptedToBase64_thenDecryptSuccessfully() throws CipherException {
    CipherFactory factory      = CipherFactory.getInstance();
    ICipher       cipherBase64 = factory.get(BASE64);
    
    for (String expectedValue : EXPECTED_MAP.keySet()) {
      String value         = EXPECTED_MAP.get(expectedValue);
      byte[] decryptedData = cipherBase64.decrypt(null, null, value.getBytes(UTF_8));
      Assert.assertNotNull(decryptedData);
      
      String decryptedText = new String(decryptedData);
      System.out.printf("Data: %s / Expected: %s / Decrypted: %s%n",
          value, expectedValue, decryptedText);
      
      Assert.assertEquals(expectedValue, decryptedText);
    }
  }
  
}
