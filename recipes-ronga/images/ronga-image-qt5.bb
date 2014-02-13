

SYSTEMD_INSTALL = " \
    systemd \
    systemd-compat-units \
    systemd-speed-hacks \
    udev-systemd \
    rsyslog-systemd \
"

SYSV_INSTALL = " \
    udev \
    sysvinit \
    initscripts \
"

MACHINE_FEATURES += "wifi"

IMAGE_FEATURES += "\
     ssh-server-openssh \
    splash \
"

DEPENDS += "\
     gpu-viv-bin-mx6q \
      libpng \
"

#core-image-minimal
IMAGE_INSTALL += "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
     ${CORE_IMAGE_EXTRA_INSTALL} \
"

#from QT-in-use-common:
IMAGE_INSTALL += " \
    base-files \
    base-passwd \
    busybox \
    ${@base_contains("MACHINE_FEATURES", "systemd", "${SYSTEMD_INSTALL}", "${SYSV_INSTALL}", d)} \
    packagegroup-fsl-gstreamer \
    packagegroup-base \
"

#CAN
#IMAGE_INSTALL += " \
#    canutils \
#"

#QT5:
IMAGE_INSTALL += " \
	gpu-viv-bin-mx6q \
     	gcc \
   	g++ \
 	binutils \
  	libgcc \
     	libgcc-dev \
    	libstdc++ \
    	libstdc++-dev \
        libstdc++-staticdev \
      	tslib-conf \
     	tslib-tests \
   	tslib-calibrate \
     	openssh-sftp-server \
   	alsa-lib \
    	alsa-tools \
   	alsa-state \
  	alsa-utils-alsaconf \
        tslib \
    	evtest \
       	dbus \
    	nano \
 	git \
       	qtbase \
  	qtbase-fonts \
       	qtbase-plugins \
  	qtbase-examples \
    	qt3d \
 	qtmultimedia \
      	qtlocation \
     	cinematicexperience \
   	gstreamer \
   	cairo \
       	pango \
  	fontconfig \
  	freetype \
  	strace \
     	gdb \
   	rsync \
       	libpng \
  	libpng12 \
   	openssh \
"

inherit core-image


